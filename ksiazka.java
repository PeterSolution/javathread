public class ksiazka /*implements Runnable*/{
    private final Object lock=new Object();
    int iloscpisarzy=0;
    int iloscczytelnikow=0;
    int pisarze=0;
    int pisarzekolej=0;
    int czytelnicy=0;
    int pisze=0;
    int kolejkaczytelnikow=0;
    String txt="aaa";
    public void write(String txttowrite){
        iloscpisarzy=iloscpisarzy+1;
        synchronized (lock) {
        if(pisarze==0&&czytelnicy==0) {
            pisze=1;
            txt = txttowrite;
            pisze=0;
            kolejkaczytelnikow=czytelnicy;
        }
        else {
            while (!(kolejkaczytelnikow==0||pisarzekolej==pisarze)){

            }
            pisze=1;
            txt=txttowrite;
            increasekolejka();
            pisze=0;
            kolejkaczytelnikow=czytelnicy;
        }
        pisarze=pisarze+1;
        iloscpisarzy=iloscpisarzy-1;



        }
    }
    public String read(){
        iloscczytelnikow=iloscczytelnikow+1;
        czytelnicy=czytelnicy+1;
        //synchronized (lock) {
        if((kolejkaczytelnikow>0&&!(pisze==1))||(pisarze==0&&kolejkaczytelnikow==0)){
            if (kolejkaczytelnikow > 0) {
                this.kolejkaczytelnikow=this.kolejkaczytelnikow-1;

            }
            iloscczytelnikow=iloscczytelnikow-1;
            return txt;
        }
        else {
            while (pisze==1){

            }
            this.kolejkaczytelnikow=this.kolejkaczytelnikow-1;
            iloscczytelnikow=iloscczytelnikow-1;
            return txt;
        }

        //}
    }

    public void increasekolejka(){
        this.pisarzekolej=pisarzekolej+1;
    }

    public int getIloscczytelnikow() {
        return iloscczytelnikow;
    }

    public int getIloscpisarzy() {
        return iloscpisarzy;
    }

    public int getPisarze() {
        return pisarze;
    }

    public int getCzytelnicy(){
        return czytelnicy;
    }

//    @Override
//    public void run() {
//        if (pisarze<pisarzekolej){
//            pisarzekolej=pisarze;
//        }
//        System.out.printf(txt);
//
//    }
}
