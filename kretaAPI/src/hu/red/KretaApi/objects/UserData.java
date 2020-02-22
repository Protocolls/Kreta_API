package hu.red.KretaApi.objects;

import hu.red.KretaApi.Utils.Kreta;

import java.util.Date;

public class UserData {
    //region Variables
    private final String TanuloAktualisOktatasNevelesiKategoriaja;
    private final int StudentId;
    private final int SchoolYearId;
    private final String Name;
    private final String NameOfBirth;
    private final String PlaceOfBirth;
    private final String MothersName;
    private final String[] AddressDataList;
    private final String DateOfBirthUtc;
    private final String InstituteName;
    private final String InstituteCode;
    private final Evaluation[] Evaluations;
    private final SubjectAverage[] SubjectAverages;
    private final Absence[] Absences;
    private final Note[] Notes;
    private final OsztalyCsoport[] OsztalyCsoportok;
    private final String Lessons;
    private final String Events;
    private final Form_Teacher FormTeacher;
    private final Osztalyfonok[] Osztalyfonokok;
    private final Tutelary[] Tutelaries;
    //endregion

    public UserData(String tanuloAktualisOktatasNevelesiKategoriaja, int studentId, int schoolYearId, String name, String nameOfBirth, String placeOfBirth, String mothersName, String[] addressDataList, String dateOfBirthUtc, String instituteName, String instituteCode, Evaluation[] evaluations, SubjectAverage[] subjectAverages, Absence[] absences, Note[] notes, OsztalyCsoport[] osztalyCsoportok, String lessons, String events, Form_Teacher formTeacher, Osztalyfonok[] osztalyfonokok, Tutelary[] tutelaries) {
        TanuloAktualisOktatasNevelesiKategoriaja = tanuloAktualisOktatasNevelesiKategoriaja;
        StudentId = studentId;
        SchoolYearId = schoolYearId;
        Name = name;
        NameOfBirth = nameOfBirth;
        PlaceOfBirth = placeOfBirth;
        MothersName = mothersName;
        AddressDataList = addressDataList;
        DateOfBirthUtc = dateOfBirthUtc;
        InstituteName = instituteName;
        InstituteCode = instituteCode;
        Evaluations = evaluations;
        SubjectAverages = subjectAverages;
        Absences = absences;
        Notes = notes;
        OsztalyCsoportok = osztalyCsoportok;
        Lessons = lessons;
        Events = events;
        FormTeacher = formTeacher;
        Osztalyfonokok = osztalyfonokok;
        Tutelaries = tutelaries;
    }
    //region getters

    public String getTanuloAktualisOktatasNevelesiKategoriaja() {
        return TanuloAktualisOktatasNevelesiKategoriaja;
    }

    public int getStudentId() {
        return StudentId;
    }

    public int getSchoolYearId() {
        return SchoolYearId;
    }

    public String getName() {
        return Name;
    }

    public String getNameOfBirth() {
        return NameOfBirth;
    }

    public String getPlaceOfBirth() {
        return PlaceOfBirth;
    }

    public String getMothersName() {
        return MothersName;
    }

    public String[] getAddressDataList() {
        return AddressDataList;
    }

    public Date getDateOfBirthUtc() {
        return Kreta.Utils.StingToDate(DateOfBirthUtc);
    }

    public String getInstituteName() {
        return InstituteName;
    }

    public String getInstituteCode() {
        return InstituteCode;
    }

    public Evaluation[] getEvaluations() {
        return Evaluations;
    }

    public SubjectAverage[] getSubjectAverages() {
        return SubjectAverages;
    }

    public Absence[] getAbsences() {
        return Absences;
    }

    public Note[] getNotes() {
        return Notes;
    }

    public OsztalyCsoport[] getOsztalyCsoportok() {
        return OsztalyCsoportok;
    }

    public String getLessons() {
        return Lessons;
    }

    public String getEvents() {
        return Events;
    }

    public Form_Teacher getFormTeacher() {
        return FormTeacher;
    }

    public Osztalyfonok[] getOsztalyfonokok() {
        return Osztalyfonokok;
    }

    public Tutelary[] getTutelaries() {
        return Tutelaries;
    }

    //endregion
    //region subclasses
    public class Evaluation {
        private final int EvaluationId;
        private final String Form;
        private final String FormName;
        private final String Type;
        private final String TypeName;
        private final String Subject;
        private final String SubjectCategory;
        private final String SubjectCategoryName;
        private final String Theme;
        private final boolean IsAtlagbaBeleszamit;
        private final String Mode;
        private final String Weight;
        private final String Value;
        private final int NumberValue;
        private final String SeenByTutelaryUTC;
        private final String Teacher;
        private final String Date;
        private final String CreatingTime;
        private final Tipus Jelleg;
        private final String JellegNev;
        private final Tipus ErtekFajta;
        private final String OsztalyCsoportUid;

        public Evaluation(int evaluationId, String form, String formName, String type, String typeName, String subject, String subjectCategory, String subjectCategoryName, String theme, boolean isAtlagbaBeleszamit, String mode, String weight, String value, int numberValue, String seenByTutelaryUTC, String teacher, String date, String creatingTime, Tipus jelleg, String jellegNev, Tipus ertekFajta, String osztalyCsoportUid) {
            EvaluationId = evaluationId;
            Form = form;
            FormName = formName;
            Type = type;
            TypeName = typeName;
            Subject = subject;
            SubjectCategory = subjectCategory;
            SubjectCategoryName = subjectCategoryName;
            Theme = theme;
            IsAtlagbaBeleszamit = isAtlagbaBeleszamit;
            Mode = mode;
            Weight = weight;
            Value = value;
            NumberValue = numberValue;
            SeenByTutelaryUTC = seenByTutelaryUTC;
            Teacher = teacher;
            Date = date;
            CreatingTime = creatingTime;
            Jelleg = jelleg;
            JellegNev = jellegNev;
            ErtekFajta = ertekFajta;
            OsztalyCsoportUid = osztalyCsoportUid;
        }

        public int getEvaluationId() {
            return EvaluationId;
        }

        public String getForm() {
            return Form;
        }

        public String getFormName() {
            return FormName;
        }

        public String getType() {
            return Type;
        }

        public String getTypeName() {
            return TypeName;
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

        public String getTheme() {
            return Theme;
        }

        public boolean isAtlagbaBeleszamit() {
            return IsAtlagbaBeleszamit;
        }

        public String getMode() {
            return Mode;
        }

        public String getWeight() {
            return Weight;
        }

        public String getValue() {
            return Value;
        }

        public int getNumberValue() {
            return NumberValue;
        }

        public String isSeenByTutelaryUTC() {
            return SeenByTutelaryUTC;
        }

        public String getTeacher() {
            return Teacher;
        }

        public Date getDate() {
            return Kreta.Utils.StingToDate(Date);
        }

        public Date getCreatingTime() {
            return Kreta.Utils.StingToDate(CreatingTime);
        }

        public Tipus getJelleg() {
            return Jelleg;
        }

        public String getJellegNev() {
            return JellegNev;
        }

        public Tipus getErtekFajta() {
            return ErtekFajta;
        }

        public String getOsztalyCsoportUid() {
            return OsztalyCsoportUid;
        }

        private class Tipus {
            private final int Id;
            private final String Nev;
            private final String Leiras;

            public Tipus(int Id, String nev, String leiras) {
                this.Id = Id;
                Nev = nev;
                Leiras = leiras;
            }

            public int getId() {
                return Id;
            }

            public String getNev() {
                return Nev;
            }

            public String getLeiras() {
                return Leiras;
            }
        }
    }

    public class SubjectAverage {
        private final int SubjectId;
        private final String Subject;
        private final String SubjectCategory;
        private final String SubjectCategoryName;
        private final float Value;
        private final int ClassValue;
        private final int Difference;

        public SubjectAverage(int subjectId, String subject, String subjectCategory, String subjectCategoryName, float value, int classValue, int difference) {
            SubjectId = subjectId;
            Subject = subject;
            SubjectCategory = subjectCategory;
            SubjectCategoryName = subjectCategoryName;
            Value = value;
            ClassValue = classValue;
            Difference = difference;
        }

        public int getSubjectId() {
            return SubjectId;
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

        public float getValue() {
            return Value;
        }

        public int getClassValue() {
            return ClassValue;
        }

        public int getDifference() {
            return Difference;
        }
    }

    public class Absence {
        private final int AbsenceId;
        private final String Type;
        private final String TypeName;
        private final String Mode;
        private final String ModeName;
        private final String Subject;
        private final String SubjectCategory;
        private final String SubjectCategoryName;
        private final int DelayTimeMinutes;
        private final String Teacher;
        private final String LessonStartTime;
        private final int NumberOfLessons;
        private final String CreatingTime;
        private final String JustificationState;
        private final String JustificationStateName;
        private final String JustificationType;
        private final String JustificationTypeName;
        private final String SeenByTutelaryUTC;
        private final String OsztalyCsoportUid;

        public Absence(int absenceId, String type, String typeName, String mode, String modeName, String subject, String subjectCategory, String subjectCategoryName, int delayTimeMinutes, String teacher, String lessonStartTime, int numberOfLessons, String creatingTime, String justificationState, String justificationStateName, String justificationType, String justificationTypeName, String seenByTutelaryUTC, String osztalyCsoportUid) {
            AbsenceId = absenceId;
            Type = type;
            TypeName = typeName;
            Mode = mode;
            ModeName = modeName;
            Subject = subject;
            SubjectCategory = subjectCategory;
            SubjectCategoryName = subjectCategoryName;
            DelayTimeMinutes = delayTimeMinutes;
            Teacher = teacher;
            LessonStartTime = lessonStartTime;
            NumberOfLessons = numberOfLessons;
            CreatingTime = creatingTime;
            JustificationState = justificationState;
            JustificationStateName = justificationStateName;
            JustificationType = justificationType;
            JustificationTypeName = justificationTypeName;
            SeenByTutelaryUTC = seenByTutelaryUTC;
            OsztalyCsoportUid = osztalyCsoportUid;
        }

        public int getAbsenceId() {
            return AbsenceId;
        }

        public String getType() {
            return Type;
        }

        public String getTypeName() {
            return TypeName;
        }

        public String getMode() {
            return Mode;
        }

        public String getModeName() {
            return ModeName;
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

        public int getDelayTimeMinutes() {
            return DelayTimeMinutes;
        }

        public String getTeacher() {
            return Teacher;
        }

        public Date getLessonStartTime() {
            return Kreta.Utils.StingToDate(LessonStartTime);
        }

        public int getNumberOfLessons() {
            return NumberOfLessons;
        }

        public Date getCreatingTime() {
            return Kreta.Utils.StingToDate(CreatingTime);
        }

        public String getJustificationState() {
            return JustificationState;
        }

        public String getJustificationStateName() {
            return JustificationStateName;
        }

        public String getJustificationType() {
            return JustificationType;
        }

        public String getJustificationTypeName() {
            return JustificationTypeName;
        }

        public String getSeenByTutelaryUTC() {
            return SeenByTutelaryUTC;
        }

        public String getOsztalyCsoportUid() {
            return OsztalyCsoportUid;
        }
    }

    public class Note {
        private final int NoteId;
        private final String Type;
        private final String Title;
        private final String Content;
        private final String SeenByTutelaryUTC;
        private final String Teacher;
        private final String Date;
        private final String CreatingTime;
        private final String OsztalyCsoportUid;

        public Note(int noteId, String type, String title, String content, String seenByTutelaryUTC, String teacher, String date, String creatingTime, String osztalyCsoportUid) {
            NoteId = noteId;
            Type = type;
            Title = title;
            Content = content;
            SeenByTutelaryUTC = seenByTutelaryUTC;
            Teacher = teacher;
            Date = date;
            CreatingTime = creatingTime;
            OsztalyCsoportUid = osztalyCsoportUid;
        }

        public int getNoteId() {
            return NoteId;
        }

        public String getType() {
            return Type;
        }

        public String getTitle() {
            return Title;
        }

        public String getContent() {
            return Content;
        }

        public String isSeenByTutelaryUTC() {
            return SeenByTutelaryUTC;
        }

        public String getTeacher() {
            return Teacher;
        }

        public Date getDate() {
            return Kreta.Utils.StingToDate(Date);
        }

        public Date getCreatingTime() {
            return Kreta.Utils.StingToDate(CreatingTime);
        }

        public String getOsztalyCsoportUid() {
            return OsztalyCsoportUid;
        }
    }

    public class OsztalyCsoport {
        private final String OktatasNevelesiKategoria;
        private final String Nev;
        private final String OsztalyCsoportTipus;
        private final boolean IsAktiv;
        private final String Uid;
        private final String OsztalyfonokUid;

        public OsztalyCsoport(String oktatasNevelesiKategoria, String nev, String osztalyCsoportTipus, boolean isAktiv, String uid, String osztalyfonokUid) {
            OktatasNevelesiKategoria = oktatasNevelesiKategoria;
            Nev = nev;
            OsztalyCsoportTipus = osztalyCsoportTipus;
            IsAktiv = isAktiv;
            Uid = uid;
            OsztalyfonokUid = osztalyfonokUid;
        }

        public String getOktatasNevelesiKategoria() {
            return OktatasNevelesiKategoria;
        }

        public String getNev() {
            return Nev;
        }

        public String getOsztalyCsoportTipus() {
            return OsztalyCsoportTipus;
        }

        public boolean isAktiv() {
            return IsAktiv;
        }

        public String getUid() {
            return Uid;
        }

        public String getOsztalyfonokUid() {
            return OsztalyfonokUid;
        }
    }

    public class Form_Teacher {
        private final int TeacherId;
        private final String Name;
        private final String Email;
        private final String PhoneNumber;

        public Form_Teacher(int teacherId, String name, String email, String phoneNumber) {
            TeacherId = teacherId;
            Name = name;
            Email = email;
            PhoneNumber = phoneNumber;
        }

        public int getTeacherId() {
            return TeacherId;
        }

        public String getName() {
            return Name;
        }

        public String getEmail() {
            return Email;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }
    }

    public class Osztalyfonok {
        private final String Uid;
        private final Teacher Tanar;
        private final Osztaly[] Osztalyai;

        public Osztalyfonok(String uid, Teacher tanar, Osztaly[] osztalyai) {
            Uid = uid;
            Tanar = tanar;
            Osztalyai = osztalyai;
        }

        public String getUid() {
            return Uid;
        }

        public Teacher getTanar() {
            return Tanar;
        }

        public Osztaly[] getOsztalyai() {
            return Osztalyai;
        }

        public class Teacher {
            private final String Uid;
            private final Employee Alkalmazott;

            public Teacher(String uid, Employee alkalmazott) {
                Uid = uid;
                Alkalmazott = alkalmazott;
            }

            public String getUid() {
                return Uid;
            }

            public Employee getAlkalmazott() {
                return Alkalmazott;
            }

            public class Employee {
                private final String Uid;
                private final String Nev;
                private final String[] Telefonok;
                private final String[] Emailek;

                public Employee(String uid, String nev, String[] telefonok, String[] emailek) {
                    Uid = uid;
                    Nev = nev;
                    Telefonok = telefonok;
                    Emailek = emailek;
                }

                public String getUid() {
                    return Uid;
                }

                public String getNev() {
                    return Nev;
                }

                public String[] getTelefonok() {
                    return Telefonok;
                }

                public String[] getEmailek() {
                    return Emailek;
                }
            }
        }

        public class Osztaly {
            private final String Uid;
            private final String Nev;

            public Osztaly(String uid, String nev) {
                Uid = uid;
                Nev = nev;
            }

            public String getUid() {
                return Uid;
            }

            public String getNev() {
                return Nev;
            }
        }
    }

    public class Tutelary {
        private final int TutelaryId;
        private final String Name;
        private final String Email;
        private final String PhoneNumber;

        public Tutelary(int tutelaryId, String name, String email, String phoneNumber) {
            TutelaryId = tutelaryId;
            Name = name;
            Email = email;
            PhoneNumber = phoneNumber;
        }

        public int getTutelaryId() {
            return TutelaryId;
        }

        public String getName() {
            return Name;
        }

        public String getEmail() {
            return Email;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }
    }
    //endregion
}
