package z5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements U6.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedReader f24800a;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f24802b;

        public a() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f24801a;
            this.f24801a = null;
            AbstractC2304t.c(str);
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.f24801a == null && !this.f24802b) {
                String line = k.this.f24800a.readLine();
                this.f24801a = line;
                if (line == null) {
                    this.f24802b = true;
                }
            }
            return this.f24801a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public k(BufferedReader reader) {
        AbstractC2304t.f(reader, "reader");
        this.f24800a = reader;
    }

    @Override // U6.h
    public Iterator iterator() {
        return new a();
    }
}
