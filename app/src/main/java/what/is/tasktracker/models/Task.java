package what.is.tasktracker.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Task implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private int priority;

    @NonNull
    @ColumnInfo
    private String title;

    @ColumnInfo
    private String content;

    @ColumnInfo
    private String timestamp;




    public Task(@NonNull int priority, String title, String content, String timestamp) {
        this.priority = priority;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Ignore
    public Task(int id, @NonNull int priority, String title, String content, String timestamp) {
        this.id = id;
        this.priority = priority;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Task() {
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj == null){
            return false;
        }
        if (getClass()!= obj.getClass()){
            return false;
        }
        Task task = (Task)obj;
        return task.getId()== getId() && task.getTitle().equals(getTitle()) && task.getContent().equals(getContent());
    }

    @Ignore
    public Task(Task task){
        id = task.id;
        priority = task.priority;
        title = task.title;
        content = task.content;
        timestamp = task.timestamp;
    }

    protected Task(Parcel in) {
        id = in.readInt();
        priority = in.readInt();
        title = in.readString();
        content = in.readString();
        timestamp = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(priority);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(timestamp);
    }
}
