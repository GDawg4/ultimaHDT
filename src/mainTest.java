import org.junit.Assert;
import org.junit.Test;

class mainTest {

    @Test
    void testChange() {
        Integer [][] testMatrix = new Integer[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j<testMatrix[i].length;j++){
                testMatrix[i][j] = 0;
            }
        }
        Assert.assertTrue(testMatrix[0][0] == 0);
        testMatrix[0][0] = 5;
        Assert.assertTrue(testMatrix[0][0] == 5);
    }
}