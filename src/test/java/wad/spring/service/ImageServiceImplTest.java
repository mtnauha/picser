/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wad.spring.domain.Image;
import wad.spring.domain.User;

/**
 *
 * @author mtnauha
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-context-test.xml", "classpath:/spring-database-test.xml", "classpath:/spring-security-test.xml"})
public class ImageServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;

    public ImageServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        User user = new User();
        user.setUsername("user1");
        user.setPassword("admin");
        userService.addUser(user);

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("user1", "admin"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addImage method, of class ImageServiceImpl.
     */
    @Test
    public void testAddImage_byteArr_String() {
        System.out.println("addImage");

        byte[] imagefile = new byte[0];
        String username = "user1";
        imageService.addImage(imagefile, username);

        Assert.assertFalse(userService.getUser("user1").getImages().isEmpty());
    }

    /**
     * Test of addImage method, of class ImageServiceImpl.
     */
    @Test
    public void testAddImage_3args() {
        System.out.println("addImage");

        byte[] imagefile = new byte[0];
        String username = "user1";
        String description = "Testing";
        imageService.addImage(imagefile, description, username);

        int lastIndex;

        List<Image> images = userService.getUser(username).getImages();

        if (images.size() > 0) {
            lastIndex = images.size() - 1;
        } else {
            lastIndex = images.size();
        }

        Assert.assertEquals(images.get(lastIndex).getDescription(), description);
    }

    /**
     * Test of addComment method, of class ImageServiceImpl.
     */
    @Test
    public void testAddComment() {
        System.out.println("addComment");

        byte[] imagefile = new byte[0];
        String username = "user1";
        imageService.addImage(imagefile, username);

        Long imageId = userService.getUser(username).getImages().get(0).getId();
        String comment = "Testing";
        imageService.addComment(imageId, comment);

        Assert.assertEquals(userService.getUser(username).getImages().get(0).getComments().get(0), comment);
    }

    /**
     * Test of getImageFile method, of class ImageServiceImpl.
     */
    @Test
    public void testGetImageFile() {
        System.out.println("getImageFile");

        byte[] imagefile = new byte[0];
        String username = "user1";
        imageService.addImage(imagefile, username);

        List<Image> images = userService.getUser(username).getImages();
        int lastIndex;

        if (images.size() > 0) {
            lastIndex = images.size() - 1;
        } else {
            lastIndex = images.size();
        }

        Long imageId = images.get(lastIndex).getId();
        byte[] expResult = imagefile;
        byte[] result = imageService.getImageFile(imageId);

        assertEquals(expResult, result);
    }

    /**
     * Test of getImage method, of class ImageServiceImpl.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");

        byte[] imagefile = new byte[0];
        String username = "user1";
        imageService.addImage(imagefile, username);

        List<Image> images = userService.getUser(username).getImages();
        int lastIndex;

        if (images.size() > 0) {
            lastIndex = images.size() - 1;
        } else {
            lastIndex = images.size();
        }

        Long imageId = images.get(lastIndex).getId();

        byte[] result = imageService.getImage(imageId).getImagefile();

        assertEquals(imagefile, result);
    }

    /**
     * Test of deleteImage method, of class ImageServiceImpl.
     */
    @Test
    public void testDeleteImage() {
        System.out.println("deleteImage");

        byte[] imagefile = new byte[0];
        String username = "user1";
        imageService.addImage(imagefile, username);

        List<Image> images = userService.getUser(username).getImages();
        int lastIndex;

        if (images.size() > 0) {
            lastIndex = images.size() - 1;
        } else {
            lastIndex = images.size();
        }

        Long imageId = images.get(lastIndex).getId();
        
        int expResult = userService.getUser(username).getImages().size() - 1;
        
        imageService.deleteImage(imageId);
        
        int result = userService.getUser(username).getImages().size();
        
        assertEquals(expResult, result);
    }
}
