import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
public abstract class Borrower {
  
  private Book[] books;
  private Date[] dueDate;
  private int daysDue;
  
  public abstract boolean noSpace();
  
  public void borrow(Book b){
    if(noSpace() == false){
      Date date = new Date();
      int noOfDays = 14;
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.setTime(date);
      calendar.add(Calendar.DATE, daysDue);
      date.setTime(calendar.getTime().getTime());
      for (int i = 0; i < books.length; i++) {
        if (books[i] == null) {
          books[i] = b;
          dueDate[i] = date;
          return;
        }
      }
    }
    else{
      fullSpace();
    }
  }
  
  public abstract void fullSpace();
  
  public abstract void returnBook();
}
