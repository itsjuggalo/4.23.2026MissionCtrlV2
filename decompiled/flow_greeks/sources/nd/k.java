package nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements jg.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedReader f17029a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f17031b;

        public a() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f17030a;
            this.f17030a = null;
            t.c(str);
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.f17030a == null && !this.f17031b) {
                String line = k.this.f17029a.readLine();
                this.f17030a = line;
                if (line == null) {
                    this.f17031b = true;
                }
            }
            return this.f17030a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public k(BufferedReader reader) {
        t.f(reader, "reader");
        this.f17029a = reader;
    }

    @Override // jg.h
    public Iterator iterator() {
        return new a();
    }
}
