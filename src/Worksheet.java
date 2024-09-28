import java.util.*;

/**
 * Node class to answer problem 1 -  huffman tree
 */
class HuffmanNode{
    char c;
    int freq;
    String path;

    public HuffmanNode(char c, int freq, String path){
        this.c = c;
        this.freq = freq;
        this.path = path;
    }
}

/**
 * Node class for B-tree
 */
class BNode{
    List data;
    List<BNode> children;

    public BNode(List data){
        this.data = data;
        this.children = new ArrayList<BNode>();
    }
    public void setChildren(List<BNode> children){
        this.children = children;
    }

    public void addChildren(BNode node){
        this.children.add(node);
    }
}




/**
 * Java file that stores answers to problem 1(huffman encoding) and problem 2(B-tree)
 */
public class Worksheet {


    /**
     * Answer to q1(a)
     * @return arrayList consisting HuffmanNodes, where each node stores info about an encoded character
     */
    public static ArrayList<HuffmanNode> q1aEncodeChar(){
        /*TODO: insert nodes into an ArrayList, where each node stores the frequency and path of a character */
        ArrayList<HuffmanNode> nodeList = new ArrayList<HuffmanNode>();
        //Example code on adding nodes: nodeList.add(new HuffmanNode('p', 2, "0001"));
        nodeList.add(new HuffmanNode('1', 1, "10100")); //49
        nodeList.add(new HuffmanNode('2', 1, "10101"));  //50
        nodeList.add(new HuffmanNode('3', 1, "10110"));  //51
        nodeList.add(new HuffmanNode('4', 1, "10111"));  //52
        nodeList.add(new HuffmanNode('5', 1, "11000"));  //53
        nodeList.add(new HuffmanNode('6', 1, "11001"));  //54
        nodeList.add(new HuffmanNode('o', 1, "11010"));  //111
        nodeList.add(new HuffmanNode('r', 1, "11011"));  //114

        nodeList.add(new HuffmanNode('\n', 4, "100"));

        nodeList.add(new HuffmanNode('0', 6, "111")); //48
        nodeList.add(new HuffmanNode('a', 6, "00")); //97
        nodeList.add(new HuffmanNode('p', 6, "01")); //112

        return nodeList;
    }

    /**
     * Answer to q1(b)
     * @return arrayList consisting HuffmanNodes, where each node stores info about an encoded character
     */
    public static ArrayList<HuffmanNode> q1bEncodeChar(){
        /*TODO: insert nodes into an ArrayList, where each node stores the frequency and path of a character */
        ArrayList<HuffmanNode> nodeList = new ArrayList<HuffmanNode>();
        //Example code on adding nodes: nodeList.add(new HuffmanNode('p', 2, "0001"));
        nodeList.add(new HuffmanNode('T', 1, "10100")); //84
        nodeList.add(new HuffmanNode('f', 1, "10101")); //102
        nodeList.add(new HuffmanNode('o', 1, "10110")); //111
        nodeList.add(new HuffmanNode('t', 1, "10111")); //116
        nodeList.add(new HuffmanNode('v', 1, "0100")); //118

        nodeList.add(new HuffmanNode('c', 2, "0101"));  //99
        nodeList.add(new HuffmanNode('e', 2, "0110"));  //101
        nodeList.add(new HuffmanNode('h', 2, "0111"));  //104
        nodeList.add(new HuffmanNode('l', 2, "1000"));  //108
        nodeList.add(new HuffmanNode('r', 2, "1001"));  //114

        nodeList.add(new HuffmanNode('a', 3, "000"));
        nodeList.add(new HuffmanNode('i', 3, "001"));

        nodeList.add(new HuffmanNode(' ', 5, "110"));
        nodeList.add(new HuffmanNode('s', 6, "111"));  //115


        return nodeList;
    }

    /**
     * Answer to 2(a)
     * @return a list of BNodes
     */
    public static ArrayList<BNode> q2EncodeTree(){
        /*TODO: insert BNodes into a nodeList, where each node stores the data and path of a character */
        ArrayList<BNode> nodeList = new ArrayList<BNode>();
        //example of adding nodes to nodeList : nodeList.add(new BNode(Arrays.asList(17,24)));
        //leaf node
        nodeList.add(new BNode(Arrays.asList(16,17,24))); //0
        nodeList.add(new BNode(Arrays.asList(36)));     //1
        nodeList.add(new BNode(Arrays.asList(43,50)));  //2
        nodeList.add(new BNode(Arrays.asList(55,60)));  //3
        nodeList.add(new BNode(Arrays.asList(70)));     //4
        nodeList.add(new BNode(Arrays.asList(103)));    //5
        
        //insert internal nodes
        nodeList.add(new BNode(Arrays.asList(32,42)));  //6
        nodeList.add(new BNode(Arrays.asList(67,78)));  //7

        nodeList.add(new BNode(Arrays.asList(53))); //8 root

        //connect root with children
        nodeList.get(8).addChildren(nodeList.get(6));
        nodeList.get(8).addChildren(nodeList.get(7));

        //connect non-root, intertal nodes with children
        //intertal node: 32, 42
        nodeList.get(6).addChildren(nodeList.get(0));
        nodeList.get(6).addChildren(nodeList.get(1));
        nodeList.get(6).addChildren(nodeList.get(2));

        //internal node 67,78
        nodeList.get(7).addChildren(nodeList.get(3));
        nodeList.get(7).addChildren(nodeList.get(4));
        nodeList.get(7).addChildren(nodeList.get(5));
        return nodeList;

    }

    public static void main(String[] args) {
        ArrayList<BNode> nodes = q2EncodeTree();
        System.out.println("number of nodes  = "+nodes.size());
        for(int i = nodes.size()-1;i>=0;i--){
            List<BNode> children = nodes.get(i).children;
            String output = "";
            output+="current data = "+nodes.get(i).data+"\n";
            output+="children = ";
            if(children.size()==0){
                output+="None";
            }
            for(int j=0;j<children.size();j++){
                output+=children.get(j).data;
            }
            System.out.println(output);
            System.out.println("____________________");
        }
    }
}
