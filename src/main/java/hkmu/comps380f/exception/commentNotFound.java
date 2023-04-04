package hkmu.comps380f.exception;

public class commentNotFound extends Exception{
    public commentNotFound(long id){ super("Comment" + id + "does not exists."); }
}
