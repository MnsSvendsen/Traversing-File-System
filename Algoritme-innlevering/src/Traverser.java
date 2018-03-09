import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Traverser {

    private static ArrayList depthDirs = new ArrayList<FileSystem.Dir>();
    private static ArrayList widthFiles = new ArrayList<FileSystem.Dir>();
    /**
     * Returns an object that allows for iteration over all the files
     * that can be found under the directory `directory`.
     *
     * The returned iterator is required to iterate over the files in
     * breadth first order. (See innlevering2.pdf for more information)
     */
    public static Iterable<FileSystem.File> getAllFiles(FileSystem.Dir directory){

        ArrayList dirs = new ArrayList<FileSystem.Dir>();
        ArrayList newDirs = new ArrayList<FileSystem.Dir>();
        ArrayList files = new ArrayList<FileSystem.File>();

        dirs.add(directory);

        while(dirs.size() > 0) {

            for (int d = 0; d < dirs.size(); d++) {
                //Prints files to the main directory.
                files = (ArrayList) (((FileSystem.Dir) dirs.get(d)).getFiles());
                for (int i = 0; i < files.size(); i++) {
                    widthFiles.add(files.get(i));
                }

                //Add all the children to a new list
                newDirs.addAll((ArrayList)((FileSystem.Dir) dirs.get(d)).getDirs());

            }

            //Adds the children fom the new list to the main directory to kep track of the children in the level
            dirs.clear();
            dirs.addAll(newDirs);
            newDirs.clear();
        }

        return widthFiles;
    }

    /**
     * Returns an object that allows for iteration over all the directories
     * that can be found under the directory `directory`.
     *
     * The returned iterator is required to iterate over the files in
     * depth first order. (See innlevering2.pdf for more information)
     */
    public static Iterable<FileSystem.Dir> getAllDirs(FileSystem.Dir directory){

        depthTraverse(directory);

        return depthDirs;
    }

    private static void depthTraverse(FileSystem.Dir directory) {

        depthDirs.add(directory);

        List huskeliste =  directory.getDirs();

        for (int i = 0; i < huskeliste.size(); i++) {
            depthTraverse((FileSystem.Dir)huskeliste.get(i));
        }
    }
}

/**
 * Starting point for advanced solution.
 * (see innlevering2.pdf for more details)
 */
class DirIterable implements Iterable<FileSystem.Dir> {

    public Iterator<FileSystem.Dir> iterator(){return new Itr();}

    class Itr implements Iterator<FileSystem.Dir> {
        public boolean hasNext(){return false;}
        public FileSystem.Dir next(){return null;}
        public void remove(){throw new UnsupportedOperationException("DFileIterable.Itr.remove()");}
    }
}
