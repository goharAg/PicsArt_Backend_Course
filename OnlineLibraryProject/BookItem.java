package OnlineLibraryProject;

public class BookItem extends Book {
    private int id;
    private boolean isChecked;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }




}
