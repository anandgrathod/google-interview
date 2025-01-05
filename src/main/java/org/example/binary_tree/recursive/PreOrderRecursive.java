package org.example.binary_tree.recursive;

import org.example.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PreOrderRecursive {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();

        if(root != null) {
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }

        return result;
    }
}
