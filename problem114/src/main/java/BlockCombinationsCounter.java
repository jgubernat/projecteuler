/**
 * Created by ejakgub on 2017-04-27.
 */
public class BlockCombinationsCounter {

    //Arguments: rowSize, minBlockSize, minGapSize
    //c(0) = ... = c(minBlockSize-1) = 1, c(minBlockSize) = 2;
    //c(n+1) = c(n) + c(n-(minBlockSize)-minGapSize) + c(n-(minBlockSize+1)-minGapSize) + ... + c(minBlockSize);
    public static void main(String... args) {
        int rowSize = Integer.parseInt(args[0]);
        int minBlockSize = Integer.parseInt(args[1]);
        int minGapSize = Integer.parseInt(args[2]);

        BlockCombinationsCounter bcc = new BlockCombinationsCounter();
        long numberOfPosibilities = bcc.count(rowSize, minBlockSize, minGapSize);
        System.out.println("Result: " + numberOfPosibilities);
    }

    private long count(int rowSize, int minBlockSize, int minGapSize) {
        long result = 1;
        if (rowSize == minBlockSize) {
            result = 2;
        }
        if (rowSize > minBlockSize) {
            for (int i = minBlockSize + minGapSize; i <= rowSize; i++) {
                result = result + count(rowSize - i, minBlockSize, minGapSize);
            }
            result = result+ count(rowSize - 1, minBlockSize, minGapSize);
        }
        return result;
    }
}
