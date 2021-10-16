package q1.extract_method.refactored;

import java.util.List;

import p5.extract_method_typeparameterize.refactored.Graph;

public class A {
   Node m1(List<Node> nodes, String p) {
      // TODO: Your answer
	   extractedMethod(nodes, p);
      // other implementation
      return null;
   }

   Edge m2(List<Edge> edgeList, String p) {
      // TODO: Your answer
	   extractedMethod(edgeList, p);
      // other implementation
      return null;
   }

   // TODO: Your answer
   <t extends Graph> void extractedMethod(List<t> objList, String p) {
   for (t object : objList) {
       if (object.contains(p))
          System.out.println(object);
    }
 }
}


	class Graph 
	{
	   String name;

	   public boolean contains(String p) {
	      return name.contains(p);
	   }

	}

	class Node extends Graph {
	}

	class Edge extends Graph {
	}
