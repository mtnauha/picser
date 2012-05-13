///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package wad.spring.service;
//
//import java.util.List;
//import org.junit.*;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import wad.spring.domain.Image;
//import wad.spring.domain.User;
//
///**
// *
// * @author mtnauha
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/spring-context-test.xml", "classpath:/spring-database-test.xml"})
//public class ImageServiceImplTest {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private ImageService imageService;
//
//    public ImageServiceImplTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @Before
//    public void setUp() {
//        User user = new User();
//        user.setUsername("useri");
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of addImage method, of class ImageServiceImpl.
//     */
//    @Test
//    public void testAddImage_byteArr_String() {
//        System.out.println("addImage");
//        byte[] imagefile = new byte[0];
//        String username = "";
//        ImageServiceImpl instance = new ImageServiceImpl();
//        instance.addImage(imagefile, username);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addImage method, of class ImageServiceImpl.
//     */
//    @Test
//    public void testAddImage_3args() {
//        System.out.println("addImage");
//        byte[] imagefile = null;
//        String description = "";
//        String username = "";
//        ImageServiceImpl instance = new ImageServiceImpl();
//        instance.addImage(imagefile, description, username);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addComment method, of class ImageServiceImpl.
//     */
//    @Test
//    public void testAddComment() {
//        System.out.println("addComment");
//        Long imageId = null;
//        String comment = "";
//        ImageServiceImpl instance = new ImageServiceImpl();
//        instance.addComment(imageId, comment);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getImageFile method, of class ImageServiceImpl.
//     */
//    @Test
//    public void testGetImageFile() {
//        System.out.println("getImageFile");
//        Long imageId = null;
//        ImageServiceImpl instance = new ImageServiceImpl();
//        byte[] expResult = null;
//        byte[] result = instance.getImageFile(imageId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getImage method, of class ImageServiceImpl.
//     */
//    @Test
//    public void testGetImage() {
//        System.out.println("getImage");
//        Long imageId = null;
//        ImageServiceImpl instance = new ImageServiceImpl();
//        Image expResult = null;
//        Image result = instance.getImage(imageId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getProfileImage method, of class ImageServiceImpl.
//     */
//    @Test
//    public void testGetProfileImage() {
//        System.out.println("getProfileImage");
//        String username = "";
//        ImageServiceImpl instance = new ImageServiceImpl();
//        byte[] expResult = null;
//        byte[] result = instance.getProfileImage(username);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setProfileImage method, of class ImageServiceImpl.
//     */
//    @Test
//    public void testSetProfileImage() {
//        System.out.println("setProfileImage");
//        String username = "";
//        Long imageId = null;
//        ImageServiceImpl instance = new ImageServiceImpl();
//        instance.setProfileImage(username, imageId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getImages method, of class ImageServiceImpl.
//     */
//    @Test
//    public void testGetImages() {
//        System.out.println("getImages");
//        String userName = "";
//        ImageServiceImpl instance = new ImageServiceImpl();
//        List expResult = null;
//        List result = instance.getImages(userName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteImage method, of class ImageServiceImpl.
//     */
//    @Test
//    public void testDeleteImage() {
//        System.out.println("deleteImage");
//        Long imageId = null;
//        ImageServiceImpl instance = new ImageServiceImpl();
//        instance.deleteImage(imageId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//}
