package P2;

import java.util.PriorityQueue;

/* JADX INFO: renamed from: P2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0219q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final A.d f2476c = new A.d(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2478b;

    public void a(Long l6) {
        PriorityQueue priorityQueue = (PriorityQueue) this.f2478b;
        if (priorityQueue.size() < this.f2477a) {
            priorityQueue.add(l6);
            return;
        }
        if (l6.longValue() < ((Long) priorityQueue.peek()).longValue()) {
            priorityQueue.poll();
            priorityQueue.add(l6);
        }
    }
}
