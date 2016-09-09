package media.t3h.com.smartrestaurant.model;

/**
 * Created by duyti on 9/8/2016.
 */
public class Table {
    private String name;
    private String waiter;
    //state == true || 0 is available table
    private boolean state;

    public Table(String name, String waiter, String state) {
        this.name = name;
        this.waiter = waiter;
        if(state.equals("0")){
            this.state = true;
        }else{
            this.state = false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
