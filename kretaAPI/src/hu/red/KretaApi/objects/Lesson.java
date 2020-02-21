package hu.red.KretaApi.objects;

import hu.red.KretaApi.Utils.KretaTools.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lesson {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-kk:mm:ss");

    private final int LessonId;
    private final String CalendarOraType;
    private final int Count;
    private final String Date;
    private final String StartTime;
    private final String EndTime;
    private final String Subject;
    private final String SubjectCategory;
    private final String SubjectCategoryName;
    private final String ClassRoom;
    private final int OsztalyCsoportId;
    private final String ClassGroup;
    private final String Teacher;
    private final String DeputyTeacher;
    private final String State;
    private final String StateName;
    private final String PresenceType;
    private final String PresenceTypeName;
    private final int TeacherHomeworkId;
    private final boolean IsTanuloHaziFeladatEnabled;
    private final String[] BejelentettSzamonkeresIdList;
    private final String Theme;
    private final String Nev;
    private final String Homework;

    public Lesson(int lessonId, String calendarOraType, int count, String date, String startTime, String endTime, String subject, String subjectCategory, String subjectCategoryName, String classRoom, int osztalyCsoportId, String classGroup, String teacher, String deputyTeacher, String state, String stateName, String presenceType, String presenceTypeName, int teacherHomeworkId, boolean isTanuloHaziFeladatEnabled, String[] bejelentettSzamonkeresIdList, String theme, String nev, String homework) {
        LessonId = lessonId;
        CalendarOraType = calendarOraType;
        Count = count;
        Date = date;
        StartTime = startTime;
        EndTime = endTime;
        Subject = subject;
        SubjectCategory = subjectCategory;
        SubjectCategoryName = subjectCategoryName;
        ClassRoom = classRoom;
        OsztalyCsoportId = osztalyCsoportId;
        ClassGroup = classGroup;
        Teacher = teacher;
        DeputyTeacher = deputyTeacher;
        State = state;
        StateName = stateName;
        PresenceType = presenceType;
        PresenceTypeName = presenceTypeName;
        TeacherHomeworkId = teacherHomeworkId;
        IsTanuloHaziFeladatEnabled = isTanuloHaziFeladatEnabled;
        BejelentettSzamonkeresIdList = bejelentettSzamonkeresIdList;
        Theme = theme;
        Nev = nev;
        Homework = homework;
    }

    public Date getDate() {
        return Utils.StingToDate(Date);
    }

    public Date getStartTime() {
        return Utils.StingToDate(StartTime);
    }

    public Date getEndTime() {
        return Utils.StingToDate(EndTime);
    }

    public int getLessonId() {
        return LessonId;
    }

    public String getCalendarOraType() {
        return CalendarOraType;
    }

    public int getCount() {
        return Count;
    }

    public String getSubject() {
        return Subject;
    }

    public String getSubjectCategory() {
        return SubjectCategory;
    }

    public String getSubjectCategoryName() {
        return SubjectCategoryName;
    }

    public String getClassRoom() {
        return ClassRoom;
    }

    public int getOsztalyCsoportId() {
        return OsztalyCsoportId;
    }

    public String getClassGroup() {
        return ClassGroup;
    }

    public String getTeacher() {
        return Teacher;
    }

    public String getDeputyTeacher() {
        return DeputyTeacher;
    }

    public String getState() {
        return State;
    }

    public String getStateName() {
        return StateName;
    }

    public String getPresenceType() {
        return PresenceType;
    }

    public String getPresenceTypeName() {
        return PresenceTypeName;
    }

    public int getTeacherHomeworkId() {
        return TeacherHomeworkId;
    }

    public boolean isTanuloHaziFeladatEnabled() {
        return IsTanuloHaziFeladatEnabled;
    }

    public String[] getBejelentettSzamonkeresIdList() {
        return BejelentettSzamonkeresIdList;
    }

    public String getTheme() {
        return Theme;
    }

    public String getNev() {
        return Nev;
    }

    public String getHomework() {
        return Homework;
    }
}
