import com.sun.xml.internal.bind.v2.runtime.Name;

import java.util.Comparator;


public class Comparators {
    public static Comparator<FileSystem.Node> NAME = new NodeNameComparator();
    public static Comparator<FileSystem.Node> REVERSED_NAME = new ReversedComparator<>(NAME);
    public static Comparator<FileSystem.Node> SIZE = new NodeSizeComparator();
    public static Comparator<FileSystem.Node> REVERSED_SIZE = new ReversedComparator<>(SIZE);
    public static Comparator<FileSystem.Dir> NUMBER_OF_CHILDREN =new DirNumberOfChildrenComparator();
    public static Comparator<FileSystem.Dir> REVERSED_NUMBER_OF_CHILDREN = new ReversedComparator<>(NUMBER_OF_CHILDREN);
}

class NodeNameComparator implements Comparator<FileSystem.Node> {
    public int compare(FileSystem.Node a, FileSystem.Node b){
        return String.CASE_INSENSITIVE_ORDER.compare(a.name(),b.name());
    }
}

class NodeSizeComparator implements Comparator<FileSystem.Node>{
    public int compare(FileSystem.Node a, FileSystem.Node b){
        return Long.compare(a.size(), b.size());
    }
}

class DirNumberOfChildrenComparator implements Comparator<FileSystem.Dir>{
    public int compare(FileSystem.Dir a, FileSystem.Dir b){
    return Long.compare(a.getDirs().size() + a.getFiles().size(),(b.getDirs().size() + b.getFiles().size()));
    }
}

/*
 * May be useful for those of you who want to follow 
 * up "Tips 3: Egen klasse for reversert komparator".
 */
class ReversedComparator<T> implements Comparator<T> {
    Comparator<T> originalComparator;

    ReversedComparator(Comparator<T> cmp) {this.originalComparator = (Comparator) cmp;
    }

    public int compare(T a, T b){return originalComparator.compare(a,b)*-1;}
}




