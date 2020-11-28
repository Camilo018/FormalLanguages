/*
 Copyright 2010 Vivin Suresh Paliath
 Distributed under the BSD License
*/

package testGrammar;

import dataStructure.NTree;
import dataStructure.TreeNode;
import enums.TreeTraversalOrderEnum;
import org.testng.annotations.Test;
import java.util.*;
import static org.testng.Assert.*;

public class TestGenericTree {
    @Test
    public void TestRootIsNullOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();
        assertNull(tree.getRoot());
    }

    @Test
    public void TestNumberOfNodesIsZeroOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();
        assertEquals(tree.getNumberOfNodes(), 0);
    }

    @Test
    public void TestIsEmptyIsTrueOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();
        assertTrue(tree.isEmpty());
    }

    @Test
    void TestExistsIsFalseOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();
        String dataToFind = "";

        assertFalse(tree.exists(dataToFind));
    }

    @Test
    void TestFindReturnsNullOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();
        String dataToFind = "";

        assertNull(tree.find(dataToFind));
    }

    @Test
    void TestPreOrderBuildReturnsNullListOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();

        assertNull(tree.build(TreeTraversalOrderEnum.PRE_ORDER));
    }

    @Test
    void TestPostOrderBuildReturnsNullListOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();

        assertNull(tree.build(TreeTraversalOrderEnum.POST_ORDER));
    }

    @Test
    void TestPreOrderBuildWithDepthReturnsNullMapOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();

        assertNull(tree.buildWithDepth(TreeTraversalOrderEnum.PRE_ORDER));
    }

    @Test
    void TestPostOrderBuildWithDepthReturnsNullMapOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();

        assertNull(tree.buildWithDepth(TreeTraversalOrderEnum.POST_ORDER));
    }

    @Test
    void TestToStringReturnsEmptyStringOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();

        assertEquals(tree.toString(), "");
    }

    @Test
    void TestToStringWithDepthReturnsEmptyStringOnNewTreeCreation() {
        NTree<String> tree = new NTree<String>();

        assertEquals(tree.toStringWithDepth(), "");
    }

    @Test
    void TestSetRootGetRoot() {
        NTree<String> tree = new NTree<String>();
        TreeNode<String> root = new TreeNode<String>();
        tree.setRoot(root);

        assertNotNull(tree.getRoot());
    }

    @Test
    void TestNumberOfNodesIsOneWithNonNullRoot() {
        NTree<String> tree = new NTree<String>();
        TreeNode<String> root = new TreeNode<String>();
        tree.setRoot(root);

        assertEquals(tree.getNumberOfNodes(), 1);
    }

    @Test
    void TestEmptyIsFalseWithNonNullRoot() {
        NTree<String> tree = new NTree<String>();
        TreeNode<String> root = new TreeNode<String>();
        tree.setRoot(root);

        assertFalse(tree.isEmpty());
    }

    @Test
    void TestPreOrderBuildListSizeIsOneWithNonNullRoot() {
        NTree<String> tree = new NTree<String>();
        TreeNode<String> root = new TreeNode<String>("root");
        tree.setRoot(root);

        assertEquals(tree.build(TreeTraversalOrderEnum.PRE_ORDER).size(), 1);
    }

    @Test
    void TestPostOrderBuildListSizeIsOneWithNonNullRoot() {
        NTree<String> tree = new NTree<String>();
        TreeNode<String> root = new TreeNode<String>("root");
        tree.setRoot(root);

        assertEquals(tree.build(TreeTraversalOrderEnum.POST_ORDER).size(), 1);
    }

    @Test
    void TestPreOrderBuildWithDepthSizeIsOneWithNonNullRoot() {
        NTree<String> tree = new NTree<String>();
        TreeNode<String> root = new TreeNode<String>("root");
        tree.setRoot(root);

        assertEquals(tree.buildWithDepth(TreeTraversalOrderEnum.PRE_ORDER).size(), 1);
    }

    @Test
    void TestPostOrderBuildWithDepthSizeIsOneWithNonNullRoot() {
        NTree<String> tree = new NTree<String>();
        TreeNode<String> root = new TreeNode<String>("root");
        tree.setRoot(root);

        assertEquals(tree.buildWithDepth(TreeTraversalOrderEnum.POST_ORDER).size(), 1);
    }

    /*
      Tree looks like:
          A
         / \
        B  C
            \
             D

      For the following tests

     */
    @Test
    void TestNumberOfNodes() {
        NTree<String> tree = new NTree<String>();

        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        assertEquals(tree.getNumberOfNodes(), 4);
    }

    @Test
    void TestExistsReturnsTrue() {
        NTree<String> tree = new NTree<String>();
        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        String dataToFindD = "D";

        assertTrue(tree.exists(dataToFindD));
    }

    @Test
    void TestFindReturnsNonNull() {
        NTree<String> tree = new NTree<String>();

        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        String dataToFindD = "D";

        assertNotNull(tree.find(dataToFindD));
    }

    @Test
    void TestExistsReturnsFalse() {
        NTree<String> tree = new NTree<String>();

        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        String dataToFindE = "E";

        assertFalse(tree.exists(dataToFindE));
    }

    @Test
    void TestFindReturnsNull() {
        NTree<String> tree = new NTree<String>();

        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        String dataToFindE = "E";

        assertNull(tree.find(dataToFindE));
    }

    // Pre-order traversal will give us A B C D
    @Test
    void TestPreOrderBuild() {
        NTree<String> tree = new NTree<String>();

        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        List<TreeNode<String>> preOrderList = new ArrayList<TreeNode<String>>();
        preOrderList.add(new TreeNode<String>("A"));
        preOrderList.add(new TreeNode<String>("B"));
        preOrderList.add(new TreeNode<String>("C"));
        preOrderList.add(new TreeNode<String>("D"));

        // Instead of checking equalities on the lists themselves, we can check equality on the toString's
        // they should generate the same toString's

        assertEquals(tree.build(TreeTraversalOrderEnum.PRE_ORDER).toString(), preOrderList.toString());
    }

    //Post-order traversal will give us B D C A
    @Test
    void TestPostOrderBuild() {
        NTree<String> tree = new NTree<String>();

        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        List<TreeNode<String>> postOrderList = new ArrayList<TreeNode<String>>();
        postOrderList.add(new TreeNode<String>("B"));
        postOrderList.add(new TreeNode<String>("D"));
        postOrderList.add(new TreeNode<String>("C"));
        postOrderList.add(new TreeNode<String>("A"));

        // Instead of checking equalities on the lists themselves, we can check equality on the toString's
        // they should generate the same toString's

        assertEquals(tree.build(TreeTraversalOrderEnum.POST_ORDER).toString(), postOrderList.toString());
     }

    //Pre-order traversal with depth will give us A:0, B:1, C:1, D:2
    @Test
    void TestPreOrderBuildWithDepth() {
        NTree<String> tree = new NTree<String>();

        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        Map<TreeNode<String>, Integer> preOrderMapWithDepth = new LinkedHashMap<TreeNode<String>, Integer>();
        preOrderMapWithDepth.put(new TreeNode<String>("A"), 0);
        preOrderMapWithDepth.put(new TreeNode<String>("B"), 1);
        preOrderMapWithDepth.put(new TreeNode<String>("C"), 1);
        preOrderMapWithDepth.put(new TreeNode<String>("D"), 2);

        // Instead of checking equalities on the maps themselves, we can check equality on the toString's
        // they should generate the same toString's

        assertEquals(tree.buildWithDepth(TreeTraversalOrderEnum.PRE_ORDER).toString(), preOrderMapWithDepth.toString());
     }

     //Post-order traversal with depth will give us B:1, D:2, C:1, A:0
    @Test
    void TestPostOrderBuildWithDepth() {
        NTree<String> tree = new NTree<String>();

        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        Map<TreeNode<String>, Integer> postOrderMapWithDepth = new LinkedHashMap<TreeNode<String>, Integer>();
        postOrderMapWithDepth.put(new TreeNode<String>("B"), 1);
        postOrderMapWithDepth.put(new TreeNode<String>("D"), 2);
        postOrderMapWithDepth.put(new TreeNode<String>("C"), 1);
        postOrderMapWithDepth.put(new TreeNode<String>("A"), 0);

        // Instead of checking equalities on the maps themselves, we can check equality on the toString's
        // they should generate the same toString's

        assertEquals(tree.buildWithDepth(TreeTraversalOrderEnum.POST_ORDER).toString(), postOrderMapWithDepth.toString());
    }

    //toString and toStringWithDepth both use pre-order traversal
    @Test
    void TestToString() {
        NTree<String> tree = new NTree<String>();

        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        List<TreeNode<String>> preOrderList = new ArrayList<TreeNode<String>>();
        preOrderList.add(new TreeNode<String>("A"));
        preOrderList.add(new TreeNode<String>("B"));
        preOrderList.add(new TreeNode<String>("C"));
        preOrderList.add(new TreeNode<String>("D"));

        assertEquals(tree.toString(), preOrderList.toString());
    }

    @Test
    void TestToStringWithDepth() {
        NTree<String> tree = new NTree<String>();

        TreeNode<String> rootA = new TreeNode<String>("A");
        TreeNode<String> childB = new TreeNode<String>("B");
        TreeNode<String> childC = new TreeNode<String>("C");
        TreeNode<String> childD = new TreeNode<String>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);

        Map<TreeNode<String>, Integer> preOrderMapWithDepth = new LinkedHashMap<TreeNode<String>, Integer>();
        preOrderMapWithDepth.put(new TreeNode<String>("A"), 0);
        preOrderMapWithDepth.put(new TreeNode<String>("B"), 1);
        preOrderMapWithDepth.put(new TreeNode<String>("C"), 1);
        preOrderMapWithDepth.put(new TreeNode<String>("D"), 2);

        assertEquals(tree.toStringWithDepth(), preOrderMapWithDepth.toString());
    }
}
