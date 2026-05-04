.class public final Lcom/google/android/gms/internal/firebase-auth-api/zzacq;
.super Lcom/google/android/gms/internal/firebase-auth-api/zzafo;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# direct methods
.method public constructor <init>(La7/g;Ljava/util/concurrent/Executor;Ljava/util/concurrent/ScheduledExecutorService;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaeo;

    .line 5
    .line 6
    invoke-direct {v0, p1, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaeo;-><init>(La7/g;Ljava/util/concurrent/ScheduledExecutorService;)V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza:Lcom/google/android/gms/internal/firebase-auth-api/zzaeo;

    .line 10
    .line 11
    iput-object p2, p0, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zzb:Ljava/util/concurrent/Executor;

    .line 12
    .line 13
    return-void
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
.end method

.method public static zza(La7/g;Lcom/google/android/gms/internal/firebase-auth-api/zzahk;)Ln7/i;
    .locals 6

    .line 174
    invoke-static {p0}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 175
    invoke-static {p1}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 176
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 177
    new-instance v1, Ln7/e;

    const-string v2, "firebase"

    invoke-direct {v1, p1, v2}, Ln7/e;-><init>(Lcom/google/android/gms/internal/firebase-auth-api/zzahk;Ljava/lang/String;)V

    .line 178
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 179
    invoke-virtual {p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzahk;->zzl()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 180
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    .line 181
    :goto_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    .line 182
    new-instance v3, Ln7/e;

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/firebase-auth-api/zzaib;

    invoke-direct {v3, v4}, Ln7/e;-><init>(Lcom/google/android/gms/internal/firebase-auth-api/zzaib;)V

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 183
    :cond_0
    new-instance v1, Ln7/i;

    invoke-direct {v1, p0, v0}, Ln7/i;-><init>(La7/g;Ljava/util/List;)V

    .line 184
    new-instance p0, Ln7/k;

    .line 185
    invoke-virtual {p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzahk;->zzb()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzahk;->zza()J

    move-result-wide v4

    invoke-direct {p0, v2, v3, v4, v5}, Ln7/k;-><init>(JJ)V

    .line 186
    invoke-virtual {v1, p0}, Ln7/i;->w0(Ln7/k;)V

    .line 187
    invoke-virtual {p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzahk;->zzn()Z

    move-result p0

    invoke-virtual {v1, p0}, Ln7/i;->x0(Z)V

    .line 188
    invoke-virtual {p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzahk;->zze()Lm7/z1;

    move-result-object p0

    invoke-virtual {v1, p0}, Ln7/i;->v0(Lm7/z1;)V

    .line 189
    invoke-virtual {p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzahk;->zzk()Ljava/util/List;

    move-result-object p0

    .line 190
    invoke-static {p0}, Ln7/o0;->a(Ljava/util/List;)Ljava/util/List;

    move-result-object p0

    .line 191
    invoke-virtual {v1, p0}, Lm7/a0;->s0(Ljava/util/List;)V

    .line 192
    invoke-virtual {p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzahk;->zzd()Lcom/google/android/gms/internal/firebase-auth-api/zzah;

    move-result-object p0

    invoke-virtual {v1, p0}, Lm7/a0;->q0(Ljava/util/List;)V

    return-object v1
.end method


# virtual methods
.method public final zza()Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/android/gms/tasks/Task<",
            "Lcom/google/android/gms/internal/firebase-auth-api/zzahr;",
            ">;"
        }
    .end annotation

    .line 40
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzada;

    invoke-direct {v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzada;-><init>()V

    .line 41
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object v0

    return-object v0
.end method

.method public final zza(La7/g;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacp;

    invoke-direct {v0, p2, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzacp;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzacp;

    .line 3
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 4
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacr;

    invoke-direct {v0, p2, p3, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzacr;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 5
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzacr;

    .line 6
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ln7/u1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ln7/u1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 7
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacu;

    invoke-direct {v0, p2, p3, p4, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzacu;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 8
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 9
    invoke-virtual {p1, p6}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzacu;

    .line 10
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Ljava/lang/String;Ljava/lang/String;Ln7/u1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ln7/u1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 129
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadt;

    invoke-direct {v0, p2, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzadt;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 131
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadt;

    .line 132
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Ljava/lang/String;Lm7/e;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ljava/lang/String;",
            "Lm7/e;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x1

    .line 115
    invoke-virtual {p3, v0}, Lm7/e;->a0(I)V

    .line 116
    new-instance v1, Lcom/google/android/gms/internal/firebase-auth-api/zzadp;

    const-string v6, "sendPasswordResetEmail"

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v1 .. v6}, Lcom/google/android/gms/internal/firebase-auth-api/zzadp;-><init>(Ljava/lang/String;Lm7/e;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadp;

    .line 118
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 92
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadk;

    invoke-direct {v0, p3, p4, p5, p6}, Lcom/google/android/gms/internal/firebase-auth-api/zzadk;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 94
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 95
    invoke-virtual {p1, p7}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 96
    invoke-virtual {p1, p7}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadk;

    .line 97
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Ljava/lang/String;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 151
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaec;

    .line 152
    invoke-virtual {p2}, Lm7/a0;->zze()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p3, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaec;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 153
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 154
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 155
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 156
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzaec;

    .line 157
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/c0;",
            ">;"
        }
    .end annotation

    .line 34
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacx;

    invoke-direct {v0, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzacx;-><init>(Ljava/lang/String;)V

    .line 35
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 36
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 37
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 38
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzacx;

    .line 39
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Lm7/c1;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/c1;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 165
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaei;

    invoke-direct {v0, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaei;-><init>(Lm7/c1;)V

    .line 166
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 167
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 168
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 169
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzaei;

    .line 170
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Lm7/h;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/h;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 44
    invoke-static {p1}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    invoke-static {p3}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    invoke-static {p2}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    invoke-static {p5}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    invoke-virtual {p2}, Lm7/a0;->zzg()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 49
    invoke-virtual {p3}, Lm7/h;->R()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 50
    new-instance p1, Lcom/google/android/gms/common/api/Status;

    const/16 p2, 0x4277

    invoke-direct {p1, p2}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    .line 51
    invoke-static {p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaen;->zza(Lcom/google/android/gms/common/api/Status;)La7/m;

    move-result-object p1

    .line 52
    invoke-static {p1}, Lcom/google/android/gms/tasks/Tasks;->forException(Ljava/lang/Exception;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1

    .line 53
    :cond_0
    instance-of v0, p3, Lm7/j;

    if-eqz v0, :cond_2

    .line 54
    check-cast p3, Lm7/j;

    invoke-virtual {p3}, Lm7/j;->X()Z

    move-result v0

    if-nez v0, :cond_1

    .line 55
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadc;

    invoke-direct {v0, p3, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzadc;-><init>(Lm7/j;Ljava/lang/String;)V

    .line 56
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 57
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 58
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 59
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadc;

    .line 60
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1

    .line 61
    :cond_1
    new-instance p4, Lcom/google/android/gms/internal/firebase-auth-api/zzadd;

    invoke-direct {p4, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzadd;-><init>(Lm7/j;)V

    .line 62
    invoke-virtual {p4, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 63
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 64
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 65
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadd;

    .line 66
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1

    .line 67
    :cond_2
    instance-of p4, p3, Lm7/o0;

    if-eqz p4, :cond_3

    .line 68
    check-cast p3, Lm7/o0;

    .line 69
    invoke-static {}, Lcom/google/android/gms/internal/firebase-auth-api/zzagb;->zza()V

    .line 70
    new-instance p4, Lcom/google/android/gms/internal/firebase-auth-api/zzade;

    invoke-direct {p4, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzade;-><init>(Lm7/o0;)V

    .line 71
    invoke-virtual {p4, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 72
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 73
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 74
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzade;

    .line 75
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1

    .line 76
    :cond_3
    invoke-static {p1}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    invoke-static {p3}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    invoke-static {p2}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    invoke-static {p5}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    new-instance p4, Lcom/google/android/gms/internal/firebase-auth-api/zzadb;

    invoke-direct {p4, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzadb;-><init>(Lm7/h;)V

    .line 81
    invoke-virtual {p4, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 82
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 83
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 84
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadb;

    .line 85
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Lm7/j;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/j;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 86
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadi;

    invoke-direct {v0, p3, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzadi;-><init>(Lm7/j;Ljava/lang/String;)V

    .line 87
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 88
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 89
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 90
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadi;

    .line 91
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Lm7/o0;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/o0;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 98
    invoke-static {}, Lcom/google/android/gms/internal/firebase-auth-api/zzagb;->zza()V

    .line 99
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadm;

    invoke-direct {v0, p3, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzadm;-><init>(Lm7/o0;Ljava/lang/String;)V

    .line 100
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 101
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 102
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 103
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadm;

    .line 104
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Lm7/o0;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/o0;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 158
    invoke-static {}, Lcom/google/android/gms/internal/firebase-auth-api/zzagb;->zza()V

    .line 159
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaef;

    invoke-direct {v0, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaef;-><init>(Lm7/o0;)V

    .line 160
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 161
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 162
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 163
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzaef;

    .line 164
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Lm7/p0;Ljava/lang/String;Ln7/u1;)Lcom/google/android/gms/tasks/Task;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/p0;",
            "Ljava/lang/String;",
            "Ln7/u1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 25
    invoke-static {}, Lcom/google/android/gms/internal/firebase-auth-api/zzagb;->zza()V

    .line 26
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacy;

    const/4 v1, 0x0

    invoke-direct {v0, p3, p4, v1}, Lcom/google/android/gms/internal/firebase-auth-api/zzacy;-><init>(Lm7/i0;Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    if-eqz p2, :cond_0

    .line 28
    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    .line 29
    :cond_0
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Lm7/v0;Ljava/lang/String;Ljava/lang/String;Ln7/u1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/v0;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ln7/u1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 30
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacy;

    invoke-direct {v0, p3, p4, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzacy;-><init>(Lm7/i0;Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    invoke-virtual {p1, p6}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    if-eqz p2, :cond_0

    .line 32
    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    .line 33
    :cond_0
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/a0;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 105
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzado;

    invoke-direct {v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzado;-><init>()V

    .line 106
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 107
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 108
    invoke-virtual {p1, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 109
    invoke-virtual {p1, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzado;

    .line 110
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/e;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/e;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 112
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadq;

    invoke-direct {v0, p3, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzadq;-><init>(Ljava/lang/String;Lm7/e;)V

    .line 113
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadq;

    .line 114
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/h;Ljava/lang/String;Ln7/u1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/h;",
            "Ljava/lang/String;",
            "Ln7/u1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 125
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadu;

    invoke-direct {v0, p2, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzadu;-><init>(Lm7/h;Ljava/lang/String;)V

    .line 126
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 127
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadu;

    .line 128
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/j;Ljava/lang/String;Ln7/u1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/j;",
            "Ljava/lang/String;",
            "Ln7/u1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 133
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadv;

    invoke-direct {v0, p2, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzadv;-><init>(Lm7/j;Ljava/lang/String;)V

    .line 134
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 135
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadv;

    .line 136
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/o0;Ljava/lang/String;Ln7/u1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/o0;",
            "Ljava/lang/String;",
            "Ln7/u1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 137
    invoke-static {}, Lcom/google/android/gms/internal/firebase-auth-api/zzagb;->zza()V

    .line 138
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzady;

    invoke-direct {v0, p2, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzady;-><init>(Lm7/o0;Ljava/lang/String;)V

    .line 139
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 140
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzady;

    .line 141
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/p0;Lm7/a0;Ljava/lang/String;Ln7/u1;)Lcom/google/android/gms/tasks/Task;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/p0;",
            "Lm7/a0;",
            "Ljava/lang/String;",
            "Ln7/u1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 16
    invoke-static {}, Lcom/google/android/gms/internal/firebase-auth-api/zzagb;->zza()V

    .line 17
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacv;

    .line 18
    invoke-virtual {p3}, Lm7/a0;->zze()Ljava/lang/String;

    move-result-object p3

    const/4 v1, 0x0

    invoke-direct {v0, p2, p3, p4, v1}, Lcom/google/android/gms/internal/firebase-auth-api/zzacv;-><init>(Lm7/i0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 19
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    .line 20
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lm7/v0;Lm7/a0;Ljava/lang/String;Ljava/lang/String;Ln7/u1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/v0;",
            "Lm7/a0;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ln7/u1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 21
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacv;

    .line 22
    invoke-virtual {p3}, Lm7/a0;->zze()Ljava/lang/String;

    move-result-object p3

    invoke-direct {v0, p2, p3, p4, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzacv;-><init>(Lm7/i0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 23
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    invoke-virtual {p1, p6}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    .line 24
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Ln7/u1;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ln7/u1;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 121
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadr;

    invoke-direct {v0, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzadr;-><init>(Ljava/lang/String;)V

    .line 122
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 123
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadr;

    .line 124
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 119
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzads;

    invoke-direct {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzads;-><init>(Ljava/lang/String;)V

    .line 120
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lcom/google/android/gms/internal/firebase-auth-api/zzahs;",
            ">;"
        }
    .end annotation

    .line 42
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacz;

    invoke-direct {v0, p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzacz;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 111
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadn;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzadn;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(Ljava/lang/String;Ljava/lang/String;Lm7/e;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lm7/e;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x7

    .line 171
    invoke-virtual {p3, v0}, Lm7/e;->a0(I)V

    .line 172
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaeh;

    invoke-direct {v0, p1, p2, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaeh;-><init>(Ljava/lang/String;Ljava/lang/String;Lm7/e;)V

    .line 173
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(Lm7/a0;Ln7/y;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lm7/a0;",
            "Ln7/y;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 11
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzact;

    invoke-direct {v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzact;-><init>()V

    .line 12
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 13
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 14
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzact;

    .line 15
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(Ln7/p;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ln7/p;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lcom/google/android/gms/internal/firebase-auth-api/zzair;",
            ">;"
        }
    .end annotation

    .line 145
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaea;

    invoke-direct {v0, p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaea;-><init>(Ln7/p;Ljava/lang/String;)V

    .line 146
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(Ln7/p;Ljava/lang/String;Ljava/lang/String;JZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/google/firebase/auth/b$b;Ljava/util/concurrent/Executor;Landroid/app/Activity;)Lcom/google/android/gms/tasks/Task;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ln7/p;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "JZZ",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z",
            "Lcom/google/firebase/auth/b$b;",
            "Ljava/util/concurrent/Executor;",
            "Landroid/app/Activity;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 142
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadx;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-wide/from16 v4, p4

    move/from16 v6, p6

    move/from16 v7, p7

    move-object/from16 v8, p8

    move-object/from16 v9, p9

    move-object/from16 v10, p10

    move/from16 v11, p11

    invoke-direct/range {v0 .. v11}, Lcom/google/android/gms/internal/firebase-auth-api/zzadx;-><init>(Ln7/p;Ljava/lang/String;Ljava/lang/String;JZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    move-object/from16 p1, p12

    move-object/from16 p3, p13

    move-object v1, v0

    move-object/from16 v0, p14

    .line 143
    invoke-virtual {v1, p1, v0, p3, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lcom/google/firebase/auth/b$b;Landroid/app/Activity;Ljava/util/concurrent/Executor;Ljava/lang/String;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    .line 144
    invoke-virtual {p0, v1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(Ln7/p;Lm7/r0;Ljava/lang/String;JZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/google/firebase/auth/b$b;Ljava/util/concurrent/Executor;Landroid/app/Activity;)Lcom/google/android/gms/tasks/Task;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ln7/p;",
            "Lm7/r0;",
            "Ljava/lang/String;",
            "JZZ",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z",
            "Lcom/google/firebase/auth/b$b;",
            "Ljava/util/concurrent/Executor;",
            "Landroid/app/Activity;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 147
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadz;

    .line 148
    invoke-virtual {p1}, Ln7/p;->zzc()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/common/internal/s;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v1, p2

    move-object v3, p3

    move-wide/from16 v4, p4

    move/from16 v6, p6

    move/from16 v7, p7

    move-object/from16 v8, p8

    move-object/from16 v9, p9

    move-object/from16 v10, p10

    move/from16 v11, p11

    invoke-direct/range {v0 .. v11}, Lcom/google/android/gms/internal/firebase-auth-api/zzadz;-><init>(Lm7/r0;Ljava/lang/String;Ljava/lang/String;JZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 149
    invoke-virtual {p2}, Lm7/j0;->a()Ljava/lang/String;

    move-result-object p1

    move-object/from16 p2, p12

    move-object/from16 p3, p13

    move-object/from16 v1, p14

    invoke-virtual {v0, p2, v1, p3, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lcom/google/firebase/auth/b$b;Landroid/app/Activity;Ljava/util/concurrent/Executor;Ljava/lang/String;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    .line 150
    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zza(La7/g;Lcom/google/android/gms/internal/firebase-auth-api/zzaij;Lcom/google/firebase/auth/b$b;Landroid/app/Activity;Ljava/util/concurrent/Executor;)V
    .locals 1

    .line 193
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaej;

    invoke-direct {v0, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaej;-><init>(Lcom/google/android/gms/internal/firebase-auth-api/zzaij;)V

    .line 194
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 195
    invoke-virtual {p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaij;->zzd()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p3, p4, p5, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lcom/google/firebase/auth/b$b;Landroid/app/Activity;Ljava/util/concurrent/Executor;Ljava/lang/String;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzaej;

    .line 196
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    return-void
.end method

.method public final zzb(La7/g;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/d;",
            ">;"
        }
    .end annotation

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacs;

    invoke-direct {v0, p2, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzacs;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzacs;

    .line 3
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzb(La7/g;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ln7/u1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ln7/u1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 33
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadw;

    invoke-direct {v0, p2, p3, p4, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzadw;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 35
    invoke-virtual {p1, p6}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadw;

    .line 36
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzb(La7/g;Ljava/lang/String;Lm7/e;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ljava/lang/String;",
            "Lm7/e;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x6

    .line 29
    invoke-virtual {p3, v0}, Lm7/e;->a0(I)V

    .line 30
    new-instance v1, Lcom/google/android/gms/internal/firebase-auth-api/zzadp;

    const-string v6, "sendSignInLinkToEmail"

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v1 .. v6}, Lcom/google/android/gms/internal/firebase-auth-api/zzadp;-><init>(Ljava/lang/String;Lm7/e;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadp;

    .line 32
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzb(La7/g;Lm7/a0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 16
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadj;

    invoke-direct {v0, p3, p4, p5, p6}, Lcom/google/android/gms/internal/firebase-auth-api/zzadj;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 18
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 19
    invoke-virtual {p1, p7}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 20
    invoke-virtual {p1, p7}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadj;

    .line 21
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzb(La7/g;Lm7/a0;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 37
    invoke-static {p1}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    invoke-static {p3}, Lcom/google/android/gms/common/internal/s;->e(Ljava/lang/String;)Ljava/lang/String;

    .line 39
    invoke-static {p2}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    invoke-static {p4}, Lcom/google/android/gms/common/internal/s;->k(Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    invoke-virtual {p2}, Lm7/a0;->zzg()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 42
    invoke-interface {v0, p3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    invoke-virtual {p2}, Lm7/a0;->X()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 43
    :cond_1
    new-instance p1, Lcom/google/android/gms/common/api/Status;

    const/16 p2, 0x4278

    invoke-direct {p1, p2, p3}, Lcom/google/android/gms/common/api/Status;-><init>(ILjava/lang/String;)V

    .line 44
    invoke-static {p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaen;->zza(Lcom/google/android/gms/common/api/Status;)La7/m;

    move-result-object p1

    .line 45
    invoke-static {p1}, Lcom/google/android/gms/tasks/Tasks;->forException(Ljava/lang/Exception;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1

    .line 46
    :cond_2
    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const-string v0, "password"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 47
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaee;

    invoke-direct {v0, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaee;-><init>(Ljava/lang/String;)V

    .line 48
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 49
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 50
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 51
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzaee;

    .line 52
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1

    .line 53
    :cond_3
    new-instance p3, Lcom/google/android/gms/internal/firebase-auth-api/zzaeb;

    invoke-direct {p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaeb;-><init>()V

    .line 54
    invoke-virtual {p3, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 55
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 56
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 57
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzaeb;

    .line 58
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzb(La7/g;Lm7/a0;Lm7/h;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/h;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 4
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadg;

    invoke-direct {v0, p3, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzadg;-><init>(Lm7/h;Ljava/lang/String;)V

    .line 5
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 6
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 7
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 8
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadg;

    .line 9
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzb(La7/g;Lm7/a0;Lm7/j;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/j;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 10
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadh;

    invoke-direct {v0, p3, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzadh;-><init>(Lm7/j;Ljava/lang/String;)V

    .line 11
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 12
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 13
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 14
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadh;

    .line 15
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzb(La7/g;Lm7/a0;Lm7/o0;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/o0;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 22
    invoke-static {}, Lcom/google/android/gms/internal/firebase-auth-api/zzagb;->zza()V

    .line 23
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadl;

    invoke-direct {v0, p3, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzadl;-><init>(Lm7/o0;Ljava/lang/String;)V

    .line 24
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 25
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 26
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 27
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadl;

    .line 28
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzc(La7/g;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/u0;",
            ">;"
        }
    .end annotation

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzacw;

    invoke-direct {v0, p2, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzacw;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzacw;

    .line 3
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzc(La7/g;Lm7/a0;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 10
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaed;

    invoke-direct {v0, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaed;-><init>(Ljava/lang/String;)V

    .line 11
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 12
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 13
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 14
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzaed;

    .line 15
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzc(La7/g;Lm7/a0;Lm7/h;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Lm7/h;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Lm7/i;",
            ">;"
        }
    .end annotation

    .line 4
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzadf;

    invoke-direct {v0, p3, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzadf;-><init>(Lm7/h;Ljava/lang/String;)V

    .line 5
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 6
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 7
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 8
    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzadf;

    .line 9
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzd(La7/g;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 7
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaek;

    invoke-direct {v0, p2, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaek;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 8
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzaek;

    .line 9
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method

.method public final zzd(La7/g;Lm7/a0;Ljava/lang/String;Ln7/k1;)Lcom/google/android/gms/tasks/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La7/g;",
            "Lm7/a0;",
            "Ljava/lang/String;",
            "Ln7/k1;",
            ")",
            "Lcom/google/android/gms/tasks/Task<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/firebase-auth-api/zzaeg;

    invoke-direct {v0, p3}, Lcom/google/android/gms/internal/firebase-auth-api/zzaeg;-><init>(Ljava/lang/String;)V

    .line 2
    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(La7/g;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 3
    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Lm7/a0;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 4
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    .line 5
    invoke-virtual {p1, p4}, Lcom/google/android/gms/internal/firebase-auth-api/zzaff;->zza(Ln7/x;)Lcom/google/android/gms/internal/firebase-auth-api/zzaff;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/firebase-auth-api/zzaeg;

    .line 6
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/firebase-auth-api/zzafo;->zza(Lcom/google/android/gms/internal/firebase-auth-api/zzafq;)Lcom/google/android/gms/tasks/Task;

    move-result-object p1

    return-object p1
.end method
