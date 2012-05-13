package wad.spring.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wad.spring.service.ImageService;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/image/{imageId}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getImage(@PathVariable Long imageId) {

        byte[] tmp;

        tmp = imageService.getImageFile(imageId);

        return tmp;
    }

    @RequestMapping(value = "image", method = RequestMethod.POST)
    //@ResponseBody
    public void addImage(@RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "filu", required = true) MultipartFile file, Principal principal) {

        System.out.println("****************************DOWEGETHERE*************************");
        System.out.println("**FILE** " + file);
        System.out.println("**DESC**" + description);

        //byte[] tmp = null;

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                if (description.isEmpty()) {
                    imageService.addImage(bytes, principal.getName());
                } else {
                    imageService.addImage(bytes, description, principal.getName());
                }

                //          tmp = bytes;
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //return tmp;
    }

    @RequestMapping(value = "/image/{imageId}", method = RequestMethod.DELETE)
    public String deleteImage(@PathVariable Long imageId) {

        //System.out.println("*****DELETE******");
        imageService.deleteImage(imageId);

        return "user/profile";
    }

    @RequestMapping(value = "/image/setprofile/{imageId}", method = RequestMethod.POST)
    public String setProfileImage(@PathVariable Long imageId, Principal principal) {

        imageService.setProfileImage(principal.getName(), imageId);

        return "user/profile";
    }

//    @RequestMapping(value = "/image/getprofile/{username}", method = RequestMethod.GET)
//    @ResponseBody
//    public byte[] getProfileImage(@PathVariable String username) {
//
//        //System.out.println("******GETPROFILEIMAGE******");
//        
//        byte[] tmp = null; //= new byte[0];
//
//        tmp = imageService.getProfileImage(username);
//
////        ApplicationContext appContext =
////                new ClassPathXmlApplicationContext(new String[]{"spring-context.xml"});
////
////        Resource resource =
////                appContext.getResource("file:testing.txt");
////
////        try {
////            InputStream is = resource.getInputStream();
////            BufferedReader br = new BufferedReader(new InputStreamReader(is));
////
////            String line;
////            System.out.println("***********SYS**************");
////            while ((line = br.readLine()) != null) {
////                System.out.println(line);
////            }
////            br.close();
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        return tmp;
//
//    }
}
