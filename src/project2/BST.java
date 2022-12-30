package project2;

/**
 *
 * @author 200316059 İkram Celal KESKİN
 */
public class BST {
    Node root;

    public BST() {
        root = null;
    }
    public String search(Node current, String key) {  //Search algorithm for binary tree
        if (current == null) {
            return null;
        }
        int compare = key.compareTo(current.key);      // Compare the key to the key of the current node return 0 or 1 or -1
        if (compare < 0) {                             // If the key is less than the current node's key, search the left subtree
            return search(current.left, key);
        } else if (compare > 0) {                        //   If the key is greater than the current node's key, search the right subtree
            return search(current.right, key);
        } else {                                              //If the key is equal to the current node's key, return the value
            return current.value;
        }
    }
    public Node insert(Node current, String key, String value) {
        if (current == null) {                    // If the current node is null, create a new node with the given key and value
            return new Node(key, value);
        }
        int compare = key.compareTo(current.key);                  // Compare the key to the key of the current node
        if (compare < 0) {                                     // If the key is less than the current node's key, insert the new node into the left subtree
            current.left = insert(current.left, key, value);
        } else if (compare > 0) {                    // If the key is greater than the current node's key, insert the new node into the right subtree
            current.right = insert(current.right, key, value);
        } else                  //If current node and key are the same,insert the new node into the left subtree because of the c
        {
            current.left = insert(current.left, key, value);
            //There was a collision when there were more than 3 words starting with the same letter so we put their keys in the left subtree to replace them
        }

        return current;
    }
    //These are the methods created so that we can call the main method
    public void insert(String key, String value) {
        root = insert(root, key, value);
    }

    public String search(String key) {
        return search(root, key);
    }

}