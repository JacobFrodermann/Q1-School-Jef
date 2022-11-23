public class Stack<ContentType> extends SgJavaLib.datenstrukturen.Stack<ContentType> {
    
    public int length = 0; 

    @Override
    public ContentType pop() {
        ContentType h = super.top();
        super.pop();
        return h;
    }
    @Override
    public void push(ContentType pContent) {
        length ++;
        super.push(pContent);
    }
    
    public Stack clone(){
        Stack<ContentType> tmp = new Stack<ContentType>(), tmp2 = new Stack<ContentType>();

        while (length != 0){
            ContentType h = pop();
            tmp.push(h);
            tmp2.push(h);
        }
        while (tmp2.length != 0) {
            push(tmp2.pop());
        }
        return tmp;
    }

    /*public ContentType[] toArray(){
        ContentType[] tmp = new ContentType[length];       
        Stack<ContentType> tmp2 = clone();
        int l = tmp2.length;
        while (tmp2.length != 0) {
            tmp[l-tmp2.length] = tmp2.pop();    
        }
    }*/

    public Stack(ContentType[] arr){
        super();
        for (ContentType c : arr) {
            push(c);
        }
    }
    public Stack() {
        super();
    }
}