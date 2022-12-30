package project2;

/**
 *
 * @author 200316059 İkram Celal KESKİN
 */
public class Node {

    //bst's node class
    String key;
    String value;
    Node left;
    Node right;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }

}
