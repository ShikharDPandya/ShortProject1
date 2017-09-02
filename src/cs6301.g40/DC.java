package cs6301.g40;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * Created by mukku on 8/29/2017.
 */
public class DC {
    class DCVertex{
        Graph.Vertex element;
        Graph.Vertex parent;
        boolean seen;
        DCVertex(Graph.Vertex u){
            element=u;
            seen=false;
                    }
     }

     DCVertex [] dcvertex;
     Graph g;

     public DC(Graph g){
         this.g =g;
         dcvertex = new DCVertex[g.size()];
         for (Graph.Vertex u:g
              ) {
             dcvertex[u.name] = new DCVertex(u);
         }
     }

    static LinkedList<Graph.Vertex> diameter(Graph g){
         LinkedList<Graph.Vertex> l = bfs(g,0);
         int first =    l.getFirst().name;
        int last =    l.getLast().name;
        l = bfs(g,last);
        return l;

    }

    static LinkedList<Graph.Vertex> bfs(Graph g, int i){
         DC dc = new DC(g);
         LinkedList<Graph.Vertex> li = new LinkedList<>();
         Queue<Graph.Vertex> qu = new LinkedList<Graph.Vertex>();
         Graph.Vertex v1 = dc.dcvertex[i].element;

         qu.add(v1);
        dc.getDCVertex(v1).seen = true;
         while (!qu.isEmpty()){
             Graph.Vertex v2 = qu.remove();

             li.add(v2);
             for (Graph.Edge e:v2
                  ) {
                 Graph.Vertex v3 = e.otherEnd(v2);
                 if(!dc.getDCVertex(v3).seen){
                     qu.add(v3);
                     dc.getDCVertex(v3).seen = true;
                     dc.getDCVertex(v3).parent =v2;
                 }
             }
         }
         LinkedList<Graph.Vertex> ls = new LinkedList<>();
         Graph.Vertex v = li.getLast();


         while(v!=null){
             ls.addFirst(v);
              v = dc.getDCVertex(v).parent;
         }
        for (DCVertex d:dc.dcvertex
             ) {
            d.seen= false;
        }

      /*  for (Graph.Vertex ver: ls
             ) {
            dc.getDCVertex(ver).seen =true;
        }*/
        for (Graph.Vertex vs: ls
             ) {
            System.out.print(vs.name+1+" ->");
        }
        System.out.println();
      return ls;
    }

    boolean seen(Graph.Vertex u){
        DCVertex dcu = getDCVertex(u);
        return dcu.seen;
    }

    DCVertex getDCVertex(Graph.Vertex u){return dcvertex[u.name];}

    public static void main (String [] args )throws FileNotFoundException {
        int evens = 0;
        Scanner in;
        if (args.length > 0) {
            File inputFile = new File(args[0]);
            in = new Scanner(inputFile);
        } else {
            in = new Scanner(System.in);
        }
        Graph g = Graph.readGraph(in);

         LinkedList<Graph.Vertex> l = diameter(g);

        /*    System.out.println(x1);
            System.out.println(y1);
            System.out.println();
      //  System.out.println("Input Graph has " + nc + " components:");
      /*  for(Graph.Vertex u: g) {
            System.out.print(u + " [ " + cc.getCCVertex(u).cno + " ] :");
            for(Graph.Edge e: u.adj) {
                Graph.Vertex v = e.otherEnd(u);
                System.out.print(e + " ");
            }*/
       /* for (Graph.Vertex node:l
             ) {
            int x = node.name+1;
            System.out.print(x+" ->");
        }*/
            System.out.println();
        }

   }
