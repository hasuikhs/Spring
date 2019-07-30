package vo;

import java.sql.Date;

public class BookVO { //db scott의 Book 자료를 java의 인스턴스화
	
			private int bookno; //number(5),
			private String title; //varchar2(12),
			private String author; //varchar2(12),
			private int price; //number(7)
			private Date pubdate; //date
			// 생성자
			public BookVO() {
				super();
			}	
			public BookVO(String title, String author, int price) {
				super();
				this.title = title;
				this.author = author;
				this.price = price;
			}
			public BookVO(int bookno, String title, String author, int price, Date pubdate) {
				super();
				this.bookno = bookno;
				this.title = title;
				this.author = author;
				this.price = price;
				this.pubdate = pubdate;
			}
			// get set
			public int getBookno() {
				return bookno;
			}
			public void setBookno(int bookno) {
				this.bookno = bookno;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getAuthor() {
				return author;
			}
			public void setAuthor(String author) {
				this.author = author;
			}
			public int getPrice() {
				return price;
			}
			public void setPrice(int price) {
				this.price = price;
			}
			public Date getPubdate() {
				return pubdate;
			}
			public void setPubdate(Date string) {
				this.pubdate = string;
			}
			
			@Override
			public String toString() {
				return "Book [bookno=" + bookno + ", title=" + title + ", author=" + author + ", price=" + price
						+ ", pubdate=" + pubdate + "]";
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((author == null) ? 0 : author.hashCode());
				result = prime * result + bookno;
				result = prime * result + price;
				result = prime * result + ((pubdate == null) ? 0 : pubdate.hashCode());
				result = prime * result + ((title == null) ? 0 : title.hashCode());
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				BookVO other = (BookVO) obj;
				if (author == null) {
					if (other.author != null)
						return false;
				} else if (!author.equals(other.author))
					return false;
				if (bookno != other.bookno)
					return false;
				if (price != other.price)
					return false;
				if (pubdate == null) {
					if (other.pubdate != null)
						return false;
				} else if (!pubdate.equals(other.pubdate))
					return false;
				if (title == null) {
					if (other.title != null)
						return false;
				} else if (!title.equals(other.title))
					return false;
				return true;
			}
			
					
}