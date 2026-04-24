package n0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f8516d;

    public h(int i, int i6, long j4, long j6) {
        this.f8513a = i;
        this.f8514b = i6;
        this.f8515c = j4;
        this.f8516d = j6;
    }

    public static h a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            h hVar = new h(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return hVar;
        } finally {
        }
    }

    public final void b(File file) throws IOException {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f8513a);
            dataOutputStream.writeInt(this.f8514b);
            dataOutputStream.writeLong(this.f8515c);
            dataOutputStream.writeLong(this.f8516d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof h)) {
            h hVar = (h) obj;
            if (this.f8514b == hVar.f8514b && this.f8515c == hVar.f8515c && this.f8513a == hVar.f8513a && this.f8516d == hVar.f8516d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f8514b), Long.valueOf(this.f8515c), Integer.valueOf(this.f8513a), Long.valueOf(this.f8516d));
    }
}
