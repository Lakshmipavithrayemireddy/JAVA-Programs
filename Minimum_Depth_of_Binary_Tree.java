class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0; // Base case

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Offer the root node
        int depth = 1; // Root node has level 1

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            /**
                Traverse all the nodes of a particular level.
                If a node doesn't have both left and right children, then it's the minimum depth reached so far. Return the answer.
                If it has children, add the children to the queue and increase the depth when going to the next level.
            */
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            depth++; // Level complete, depth increased for next iteration.
        }

        return depth;
    }
}

/**

Time Complexity: 
-> O(n) in the worst case, where n is the number of nodes.
-> In practice, BFS often stops early when it finds the first leaf, so it's usually faster.

Space Complexity:
-> O(w) where w is the maximum width of the tree (BFS queue size).

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
