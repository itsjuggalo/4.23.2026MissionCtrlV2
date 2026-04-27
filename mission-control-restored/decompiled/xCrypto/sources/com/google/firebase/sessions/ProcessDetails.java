package com.google.firebase.sessions;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessDetails {
    private final int importance;
    private final boolean isDefaultProcess;
    private final int pid;
    private final String processName;

    public ProcessDetails(String processName, int i4, int i5, boolean z4) {
        r.f(processName, "processName");
        this.processName = processName;
        this.pid = i4;
        this.importance = i5;
        this.isDefaultProcess = z4;
    }

    public static /* synthetic */ ProcessDetails copy$default(ProcessDetails processDetails, String str, int i4, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = processDetails.processName;
        }
        if ((i6 & 2) != 0) {
            i4 = processDetails.pid;
        }
        if ((i6 & 4) != 0) {
            i5 = processDetails.importance;
        }
        if ((i6 & 8) != 0) {
            z4 = processDetails.isDefaultProcess;
        }
        return processDetails.copy(str, i4, i5, z4);
    }

    public final String component1() {
        return this.processName;
    }

    public final int component2() {
        return this.pid;
    }

    public final int component3() {
        return this.importance;
    }

    public final boolean component4() {
        return this.isDefaultProcess;
    }

    public final ProcessDetails copy(String processName, int i4, int i5, boolean z4) {
        r.f(processName, "processName");
        return new ProcessDetails(processName, i4, i5, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessDetails)) {
            return false;
        }
        ProcessDetails processDetails = (ProcessDetails) obj;
        return r.b(this.processName, processDetails.processName) && this.pid == processDetails.pid && this.importance == processDetails.importance && this.isDefaultProcess == processDetails.isDefaultProcess;
    }

    public final int getImportance() {
        return this.importance;
    }

    public final int getPid() {
        return this.pid;
    }

    public final String getProcessName() {
        return this.processName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((((this.processName.hashCode() * 31) + Integer.hashCode(this.pid)) * 31) + Integer.hashCode(this.importance)) * 31;
        boolean z4 = this.isDefaultProcess;
        ?? r12 = z4;
        if (z4) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    public final boolean isDefaultProcess() {
        return this.isDefaultProcess;
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.processName + ", pid=" + this.pid + ", importance=" + this.importance + ", isDefaultProcess=" + this.isDefaultProcess + ')';
    }
}
