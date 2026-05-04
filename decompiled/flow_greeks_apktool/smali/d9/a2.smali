.class public Ld9/a2;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final a:Lcom/google/firebase/firestore/FirebaseFirestore;

.field public final b:Ljava/util/ArrayList;

.field public c:Z


# direct methods
.method public constructor <init>(Lcom/google/firebase/firestore/FirebaseFirestore;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/ArrayList;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Ld9/a2;->b:Ljava/util/ArrayList;

    .line 10
    .line 11
    const/4 v0, 0x0

    .line 12
    iput-boolean v0, p0, Ld9/a2;->c:Z

    .line 13
    .line 14
    invoke-static {p1}, Ln9/x;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 15
    .line 16
    .line 17
    move-result-object p1

    .line 18
    check-cast p1, Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 19
    .line 20
    iput-object p1, p0, Ld9/a2;->a:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 21
    .line 22
    return-void
    .line 23
    .line 24
.end method

.method public static synthetic a(Ld9/a2;Lg9/q0;)Lcom/google/android/gms/tasks/Task;
    .locals 0

    .line 1
    iget-object p0, p0, Ld9/a2;->b:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {p1, p0}, Lg9/q0;->T(Ljava/util/List;)Lcom/google/android/gms/tasks/Task;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    return-object p0
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
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
.end method


# virtual methods
.method public b()Lcom/google/android/gms/tasks/Task;
    .locals 2

    .line 1
    invoke-virtual {p0}, Ld9/a2;->h()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x1

    .line 5
    iput-boolean v0, p0, Ld9/a2;->c:Z

    .line 6
    .line 7
    iget-object v0, p0, Ld9/a2;->b:Ljava/util/ArrayList;

    .line 8
    .line 9
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    .line 10
    .line 11
    .line 12
    move-result v0

    .line 13
    if-nez v0, :cond_0

    .line 14
    .line 15
    iget-object v0, p0, Ld9/a2;->a:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 16
    .line 17
    new-instance v1, Ld9/z1;

    .line 18
    .line 19
    invoke-direct {v1, p0}, Ld9/z1;-><init>(Ld9/a2;)V

    .line 20
    .line 21
    .line 22
    invoke-virtual {v0, v1}, Lcom/google/firebase/firestore/FirebaseFirestore;->s(Ln9/t;)Ljava/lang/Object;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    check-cast v0, Lcom/google/android/gms/tasks/Task;

    .line 27
    .line 28
    return-object v0

    .line 29
    :cond_0
    const/4 v0, 0x0

    .line 30
    invoke-static {v0}, Lcom/google/android/gms/tasks/Tasks;->forResult(Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task;

    .line 31
    .line 32
    .line 33
    move-result-object v0

    .line 34
    return-object v0
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
.end method

.method public c(Lcom/google/firebase/firestore/c;)Ld9/a2;
    .locals 3

    .line 1
    iget-object v0, p0, Ld9/a2;->a:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lcom/google/firebase/firestore/FirebaseFirestore;->R(Lcom/google/firebase/firestore/c;)V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p0}, Ld9/a2;->h()V

    .line 7
    .line 8
    .line 9
    iget-object v0, p0, Ld9/a2;->b:Ljava/util/ArrayList;

    .line 10
    .line 11
    new-instance v1, Lk9/c;

    .line 12
    .line 13
    invoke-virtual {p1}, Lcom/google/firebase/firestore/c;->q()Lj9/k;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    sget-object v2, Lk9/m;->c:Lk9/m;

    .line 18
    .line 19
    invoke-direct {v1, p1, v2}, Lk9/c;-><init>(Lj9/k;Lk9/m;)V

    .line 20
    .line 21
    .line 22
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 23
    .line 24
    .line 25
    return-object p0
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
.end method

.method public d(Lcom/google/firebase/firestore/c;Ljava/lang/Object;)Ld9/a2;
    .locals 1

    .line 1
    sget-object v0, Ld9/q1;->c:Ld9/q1;

    .line 2
    .line 3
    invoke-virtual {p0, p1, p2, v0}, Ld9/a2;->e(Lcom/google/firebase/firestore/c;Ljava/lang/Object;Ld9/q1;)Ld9/a2;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    return-object p1
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
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
.end method

.method public e(Lcom/google/firebase/firestore/c;Ljava/lang/Object;Ld9/q1;)Ld9/a2;
    .locals 1

    .line 1
    iget-object v0, p0, Ld9/a2;->a:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lcom/google/firebase/firestore/FirebaseFirestore;->R(Lcom/google/firebase/firestore/c;)V

    .line 4
    .line 5
    .line 6
    const-string v0, "Provided data must not be null."

    .line 7
    .line 8
    invoke-static {p2, v0}, Ln9/x;->c(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    const-string v0, "Provided options must not be null."

    .line 12
    .line 13
    invoke-static {p3, v0}, Ln9/x;->c(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    invoke-virtual {p0}, Ld9/a2;->h()V

    .line 17
    .line 18
    .line 19
    invoke-virtual {p3}, Ld9/q1;->b()Z

    .line 20
    .line 21
    .line 22
    move-result v0

    .line 23
    if-eqz v0, :cond_0

    .line 24
    .line 25
    iget-object v0, p0, Ld9/a2;->a:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 26
    .line 27
    invoke-virtual {v0}, Lcom/google/firebase/firestore/FirebaseFirestore;->F()Ld9/x1;

    .line 28
    .line 29
    .line 30
    move-result-object v0

    .line 31
    invoke-virtual {p3}, Ld9/q1;->a()Lk9/d;

    .line 32
    .line 33
    .line 34
    move-result-object p3

    .line 35
    invoke-virtual {v0, p2, p3}, Ld9/x1;->g(Ljava/lang/Object;Lk9/d;)Lg9/s1;

    .line 36
    .line 37
    .line 38
    move-result-object p2

    .line 39
    goto :goto_0

    .line 40
    :cond_0
    iget-object p3, p0, Ld9/a2;->a:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 41
    .line 42
    invoke-virtual {p3}, Lcom/google/firebase/firestore/FirebaseFirestore;->F()Ld9/x1;

    .line 43
    .line 44
    .line 45
    move-result-object p3

    .line 46
    invoke-virtual {p3, p2}, Ld9/x1;->l(Ljava/lang/Object;)Lg9/s1;

    .line 47
    .line 48
    .line 49
    move-result-object p2

    .line 50
    :goto_0
    iget-object p3, p0, Ld9/a2;->b:Ljava/util/ArrayList;

    .line 51
    .line 52
    invoke-virtual {p1}, Lcom/google/firebase/firestore/c;->q()Lj9/k;

    .line 53
    .line 54
    .line 55
    move-result-object p1

    .line 56
    sget-object v0, Lk9/m;->c:Lk9/m;

    .line 57
    .line 58
    invoke-virtual {p2, p1, v0}, Lg9/s1;->a(Lj9/k;Lk9/m;)Lk9/f;

    .line 59
    .line 60
    .line 61
    move-result-object p1

    .line 62
    invoke-virtual {p3, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 63
    .line 64
    .line 65
    return-object p0
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

.method public final f(Lcom/google/firebase/firestore/c;Lg9/t1;)Ld9/a2;
    .locals 2

    .line 1
    iget-object v0, p0, Ld9/a2;->a:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lcom/google/firebase/firestore/FirebaseFirestore;->R(Lcom/google/firebase/firestore/c;)V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p0}, Ld9/a2;->h()V

    .line 7
    .line 8
    .line 9
    iget-object v0, p0, Ld9/a2;->b:Ljava/util/ArrayList;

    .line 10
    .line 11
    invoke-virtual {p1}, Lcom/google/firebase/firestore/c;->q()Lj9/k;

    .line 12
    .line 13
    .line 14
    move-result-object p1

    .line 15
    const/4 v1, 0x1

    .line 16
    invoke-static {v1}, Lk9/m;->a(Z)Lk9/m;

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    invoke-virtual {p2, p1, v1}, Lg9/t1;->a(Lj9/k;Lk9/m;)Lk9/f;

    .line 21
    .line 22
    .line 23
    move-result-object p1

    .line 24
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 25
    .line 26
    .line 27
    return-object p0
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
.end method

.method public g(Lcom/google/firebase/firestore/c;Ljava/util/Map;)Ld9/a2;
    .locals 1

    .line 1
    iget-object v0, p0, Ld9/a2;->a:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/google/firebase/firestore/FirebaseFirestore;->F()Ld9/x1;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-virtual {v0, p2}, Ld9/x1;->o(Ljava/util/Map;)Lg9/t1;

    .line 8
    .line 9
    .line 10
    move-result-object p2

    .line 11
    invoke-virtual {p0, p1, p2}, Ld9/a2;->f(Lcom/google/firebase/firestore/c;Lg9/t1;)Ld9/a2;

    .line 12
    .line 13
    .line 14
    move-result-object p1

    .line 15
    return-object p1
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
.end method

.method public final h()V
    .locals 2

    .line 1
    iget-boolean v0, p0, Ld9/a2;->c:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 7
    .line 8
    const-string v1, "A write batch can no longer be used after commit() has been called."

    .line 9
    .line 10
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 11
    .line 12
    .line 13
    throw v0
    .line 14
    .line 15
    .line 16
.end method
