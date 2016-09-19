package biz.sendu.postcardmanage.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by parkjaesung on 2016. 8. 12..
 */
@MultipartConfig
public class CardImageUpload extends HttpServlet{

    //Query should include uuid for order & file checksum
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("CardImageUpload doPost");
        StringBuffer fileDir = new StringBuffer("root/sendu/postcard/");

        String useruuid = request.getParameter("orderuuid");
        String checkSumInput = request.getParameter("checksum");

        fileDir.append(useruuid);
        //fileDir.append("test");
        fileDir.append(".jpg");

        InputStream in = request.getPart("userfile").getInputStream();
        OutputStream out = new FileOutputStream(new File(fileDir.toString()));

        copy(in, out); //The function is below
        out.flush();
        out.close();

        File checkSumFile = new File(fileDir.toString());

        MessageDigest md5Digest = null;
        try {
            md5Digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

            response.sendError(500, "Exception for getting FileChecksum");
        }

        String checkSum = getFileChecksum(md5Digest, checkSumFile);

        if(!checkSum.equals(checkSumInput)){
            response.sendError(500, "Wrong Checksum. Send File Again");

            //TODO Delete Image file if checksum isn't correct
            return;
        }

        response.setStatus(200);

        PrintWriter pw = response.getWriter();

        pw.write("success");
    }

    public static long copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[4096];

        long count = 0L;
        int n = 0;

        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    /*
    Example for getting checksum of md5
    //Create checksum for this file
    File file = new File("c:/temp/testOut.txt");

    //Use MD5 algorithm
    MessageDigest md5Digest = MessageDigest.getInstance("MD5");

    //Get the checksum
    String checksum = getFileChecksum(md5Digest, file);

    //see checksum
    System.out.println(checksum);
     */

    //Method for file CheckSum
    private static String getFileChecksum(MessageDigest digest, File file) throws IOException
    {
        //Get file input stream for reading the file content
        FileInputStream fis = new FileInputStream(file);

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        //Read file data and update in message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };

        //close the stream; We don't need it now.
        fis.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }

}
