package com.google.firebase;

import W2.o;
import W2.t;
import android.os.Parcel;
import android.os.Parcelable;
import j$.time.Instant;
import java.util.Date;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    private final int nanoseconds;
    private final long seconds;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Timestamp> CREATOR = new Parcelable.Creator<Timestamp>() { // from class: com.google.firebase.Timestamp$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp createFromParcel(Parcel source) {
            r.f(source, "source");
            return new Timestamp(source.readLong(), source.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp[] newArray(int i4) {
            return new Timestamp[i4];
        }
    };

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final o toPreciseTime(Date date) {
            long j4 = 1000;
            long time = date.getTime() / j4;
            int time2 = (int) ((date.getTime() % j4) * ((long) 1000000));
            return time2 < 0 ? t.a(Long.valueOf(time - 1), Integer.valueOf(time2 + 1000000000)) : t.a(Long.valueOf(time), Integer.valueOf(time2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateRange(long j4, int i4) {
            if (i4 < 0 || i4 >= 1000000000) {
                throw new IllegalArgumentException(("Timestamp nanoseconds out of range: " + i4).toString());
            }
            if (-62135596800L > j4 || j4 >= 253402300800L) {
                throw new IllegalArgumentException(("Timestamp seconds out of range: " + j4).toString());
            }
        }

        public final Timestamp now() {
            return new Timestamp(new Date());
        }

        private Companion() {
        }
    }

    public Timestamp(long j4, int i4) {
        Companion.validateRange(j4, i4);
        this.seconds = j4;
        this.nanoseconds = i4;
    }

    public static final Timestamp now() {
        return Companion.now();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Timestamp) && compareTo((Timestamp) obj) == 0;
        }
        return true;
    }

    public final int getNanoseconds() {
        return this.nanoseconds;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j4 = this.seconds;
        return (((((int) j4) * 1369) + ((int) (j4 >> 32))) * 37) + this.nanoseconds;
    }

    public final Date toDate() {
        return new Date((this.seconds * ((long) 1000)) + ((long) (this.nanoseconds / 1000000)));
    }

    public final Instant toInstant() {
        Instant instantOfEpochSecond = Instant.ofEpochSecond(this.seconds, this.nanoseconds);
        r.e(instantOfEpochSecond, "ofEpochSecond(seconds, nanoseconds.toLong())");
        return instantOfEpochSecond;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.seconds + ", nanoseconds=" + this.nanoseconds + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i4) {
        r.f(dest, "dest");
        dest.writeLong(this.seconds);
        dest.writeInt(this.nanoseconds);
    }

    @Override // java.lang.Comparable
    public int compareTo(Timestamp other) {
        r.f(other, "other");
        return Y2.a.b(this, other, new B() { // from class: com.google.firebase.Timestamp.compareTo.1
            @Override // kotlin.jvm.internal.B, p3.j
            public Object get(Object obj) {
                return Long.valueOf(((Timestamp) obj).getSeconds());
            }
        }, new B() { // from class: com.google.firebase.Timestamp.compareTo.2
            @Override // kotlin.jvm.internal.B, p3.j
            public Object get(Object obj) {
                return Integer.valueOf(((Timestamp) obj).getNanoseconds());
            }
        });
    }

    public Timestamp(Date date) {
        r.f(date, "date");
        Companion companion = Companion;
        o preciseTime = companion.toPreciseTime(date);
        long jLongValue = ((Number) preciseTime.a()).longValue();
        int iIntValue = ((Number) preciseTime.b()).intValue();
        companion.validateRange(jLongValue, iIntValue);
        this.seconds = jLongValue;
        this.nanoseconds = iIntValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Timestamp(Instant time) {
        this(time.getEpochSecond(), time.getNano());
        r.f(time, "time");
    }
}
