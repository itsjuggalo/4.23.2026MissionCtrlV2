package g3;

import j3.InterfaceC1564a;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements q3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedReader f11966a;

    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11968b;

        public a() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f11967a;
            this.f11967a = null;
            r.c(str);
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.f11967a == null && !this.f11968b) {
                String line = k.this.f11966a.readLine();
                this.f11967a = line;
                if (line == null) {
                    this.f11968b = true;
                }
            }
            return this.f11967a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public k(BufferedReader reader) {
        r.f(reader, "reader");
        this.f11966a = reader;
    }

    @Override // q3.e
    public Iterator iterator() {
        return new a();
    }
}
