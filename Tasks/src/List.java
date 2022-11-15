public class List<ContentType> extends SgJavaLib.datenstrukturen.List<ContentType> {
    private int size = 0;
    @Override
    public void append(ContentType c){
        size ++;
        super.append(c);
    }
    @Override
    public void remove(){
        if(!hasAccess()) throw new IndexOutOfBoundsException();
        size --;
        super.remove();
    }
    @Override
    public void insert(ContentType c) {
        if (!hasAccess()) throw new IndexOutOfBoundsException();
        size--;
        super.remove();
    }
    ContentType get(int where) {
        toFirst();
        for(int i = 0; i<where; i++){next();}
        return getContent();
    }
    
    void Goto(int where) {
        toFirst();
        for (int i = 0;i<where; i++) {
            next();
        }
    }
    void clear(){
        toFirst();
        while (hasAccess()) remove();
    }    
}
