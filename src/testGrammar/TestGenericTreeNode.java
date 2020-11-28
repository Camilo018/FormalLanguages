/*

 Copyright 2010 Vivin Suresh Paliath
 Distributed under the BSD License
*/

package testGrammar;

import dataStructure.TreeNode;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;

public class TestGenericTreeNode {
    @Test
    public void TestNodeDataIsNullOnNewNodeCreation() {
        TreeNode<String> node = new TreeNode<String>();
        assertNull(node.getData());
    }

    @Test
    public void TestNodeHasNonNullChildrenListOnNewNodeCreation() {
        TreeNode<String> node = new TreeNode<String>();
        assertNotNull(node.getChildren());
    }

    @Test
    public void TestNodeHasZeroChildrenOnNewNodeCreation() {
        TreeNode<String> node = new TreeNode<String>();
        assertEquals(node.getNumberOfChildren(), 0);
    }

    @Test
    public void TestNodeHasChildrenReturnsFalseOnNewNodeCreation() {
        TreeNode<String> node = new TreeNode<String>();
        assertFalse(node.hasChildren());
    }

    @Test
    public void TestNodeDataIsNonNullWithParameterizedConstructor() {
        TreeNode<String> node = new TreeNode<String>("I haz data");
        assertNotNull(node.getData());
    }

    @Test
    public void TestNodeSetAndGetData() {
        TreeNode<String> node = new TreeNode<String>();
        String data = "data";
        node.setData(data);
        assertEquals(node.getData(), data);
    }

    @Test
    public void TestNodeSetAndGetChildren() {
        TreeNode<String> node = new TreeNode<String>();
        TreeNode<String> child = new TreeNode<String>();

        List<TreeNode<String>> children = new ArrayList<TreeNode<String>>();
        children.add(child);

        node.setChildren(children);
        assertEquals(node.getChildren(), children);
    }

    @Test
    public void TestNodeSetAndGetChildrenHasCorrectParent() {
        TreeNode<String> node = new TreeNode<String>();
        TreeNode<String> child = new TreeNode<String>();

        List<TreeNode<String>> children = new ArrayList<TreeNode<String>>();
        children.add(child);

        node.setChildren(children);
        assertEquals(node.getChildren(), children);

        for(TreeNode<String> childNode : children) {
            assertEquals(node, childNode.getParent());
        }
    }

    @Test
    public void TestNodeRemoveChildren() {
        TreeNode<String> node = new TreeNode<String>();
        TreeNode<String> child = new TreeNode<String>();

        List<TreeNode<String>> children = new ArrayList<TreeNode<String>>();
        children.add(child);

        node.setChildren(children);
        node.removeChildren();
        assertEquals(node.getChildren().size(), 0);
    }

    @Test
    public void TestNodeAddChildHasCorrectParent() {
        TreeNode<String> node = new TreeNode<String>();
        TreeNode<String> child = new TreeNode<String>();

        node.addChild(child);
        assertEquals(node, child.getParent());
    }

    @Test
    public void TestNodeAddChildHasOneChild() {
        TreeNode<String> node = new TreeNode<String>();
        TreeNode<String> child = new TreeNode<String>();

        node.addChild(child);
        assertEquals(node.getNumberOfChildren(), 1);
    }

    @Test
    public void TestNodeAddChildHasChildrenIsTrue() {
        TreeNode<String> node = new TreeNode<String>();
        TreeNode<String> child = new TreeNode<String>();

        node.addChild(child);
        assertTrue(node.hasChildren());
    }

    @Test
    public void TestNodeAddAndGetChildAt() {
        TreeNode<String> node = new TreeNode<String>("root");
        TreeNode<String> child1 = new TreeNode<String>("child1");
        TreeNode<String> child2 = new TreeNode<String>("child2");

        node.addChild(child1);
        node.addChildAt(1, child2);

        assertEquals(node.getChildAt(1).getData(), child2.getData());
    }

    @Test
    public void TestNodeAddAndRemoveChildAt() {
        TreeNode<String> node = new TreeNode<String>("root");
        TreeNode<String> child1 = new TreeNode<String>("child1");
        TreeNode<String> child2 = new TreeNode<String>("child2");

        node.addChild(child1);
        node.addChildAt(1, child2);

        node.removeChildAt(0);

        assertEquals(node.getNumberOfChildren(), 1);
    }

    @Test(expectedExceptions = java.lang.IndexOutOfBoundsException.class)
    public void TestNodeAddChildAtThrowsException() {
        TreeNode<String> node = new TreeNode<String>();
        TreeNode<String> child = new TreeNode<String>();

        node.addChildAt(5, child);
    }

    @Test(expectedExceptions = java.lang.IndexOutOfBoundsException.class)
    public void TestNodeRemoveChildAtThrowsException() {
        TreeNode<String> node = new TreeNode<String>();
        node.removeChildAt(1);
    }

    @Test
    public void TestNodeToString() {
        TreeNode<String> node = new TreeNode<String>();
        node.setData("data");
        assertEquals(node.toString(), "data");
    }

    @Test
    public void TestNodeToStringVerboseNoChildren() {
        TreeNode<String> node = new TreeNode<String>();
        node.setData("data");
        assertEquals(node.toStringVerbose(), "data:[]");
    }

    @Test
    public void TestNodeToStringVerboseOneChild() {
        TreeNode<String> node = new TreeNode<String>();
        node.setData("data");

        TreeNode<String> child = new TreeNode<String>();
        child.setData("child");

        node.addChild(child);
        assertEquals(node.toStringVerbose(), "data:[child]");
    }

    @Test
    public void TestNodeToStringVerboseMoreThanOneChild() {
        TreeNode<String> node = new TreeNode<String>();
        node.setData("data");

        TreeNode<String> child1 = new TreeNode<String>();
        child1.setData("child1");

        TreeNode<String> child2 = new TreeNode<String>();
        child2.setData("child2");

        node.addChild(child1);
        node.addChild(child2);

        assertEquals(node.toStringVerbose(), "data:[child1, child2]");
    }
}
