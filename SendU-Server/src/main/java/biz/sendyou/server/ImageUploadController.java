package biz.sendyou.server;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.*;
import java.security.MessageDigest;

/**
 * Created by parkjaesung on 2016. 9. 19..
 */
@RestController
public class ImageUploadController {

    @RequestMapping(value = "/order/image/{orderuuid}", method = RequestMethod.POST)
    public ResponseEntity<?> newImage(@RequestPart MultipartFile imageFile, @PathParam("orderuuid") String orderuuid) throws IOException {
        String imageFileName = imageFile.getOriginalFilename();
        String imageFileNameExtension = FilenameUtils.getExtension(imageFileName).toLowerCase();

        StringBuffer fileDir = new StringBuffer("root/sendu/postcard/");

        fileDir.append(orderuuid);
        //fileDir.append("test");
        fileDir.append(".jpg");

        InputStream in = imageFile.getInputStream();
        OutputStream out = new FileOutputStream(new File(fileDir.toString()));

        copy(in, out); //The function is below
        out.flush();
        out.close();

        //TODO Check File Checksum

        return new ResponseEntity<>(HttpStatus.OK);
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
