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
        super.insert(c);
        if (!hasAccess()) throw new IndexOutOfBoundsException();
        else {size++;}
    }
    public void insert(int where,ContentType c) {
        toFirst();
        for (int i = 0; i>where; i++) next();
        super.insert(c);
        if (!hasAccess()) throw new IndexOutOfBoundsException();
        else {size++;}
    }
    public void add(ContentType c) {append(c);}
    public void add(int where, ContentType c){insert(where, c);}
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
    
    ContentType[] toArray() { //basic
        toFirst();
        ContentType[] arr = new ContentType[size];
        toFirst();
        for (int i = 0; hasAccess(); i++){
             arr[i] = getContent();
             next();
        }
        return arr;
    }
}
