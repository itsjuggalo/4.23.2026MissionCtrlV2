package O5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Y5.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedReader f4237a;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4239b;

        public a() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f4238a;
            this.f4238a = null;
            r.c(str);
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.f4238a == null && !this.f4239b) {
                String line = k.this.f4237a.readLine();
                this.f4238a = line;
                if (line == null) {
                    this.f4239b = true;
                }
            }
            return this.f4238a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public k(BufferedReader reader) {
        r.f(reader, "reader");
        this.f4237a = reader;
    }

    @Override // Y5.f
    public Iterator iterator() {
        return new a();
    }
}
