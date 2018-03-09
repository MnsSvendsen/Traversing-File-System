public class TraverserClient {
    public static void main(String[] args){
        System.out.println("TRAVERSER CLIENT");

        FileSystem.Dir current = FileSystem.getCurrentDir();

        System.out.println("\nFiles listed in increasing distance from current directory: (i.e. in breadth first order)");
        for (FileSystem.File f : Traverser.getAllFiles(current))
            System.out.println(f);

        System.out.println("\nSubdirectories listed in depth-first order:");
        for(FileSystem.Dir d : Traverser.getAllDirs(current))
            System.out.println(d);

    }
}
