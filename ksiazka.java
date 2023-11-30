public class ksiazka {
    String txt="";
    public synchronized void write(String txttowrite){
        txt=txt+txttowrite;
    }
    public synchronized String read(){
        return txt;
    }
}
