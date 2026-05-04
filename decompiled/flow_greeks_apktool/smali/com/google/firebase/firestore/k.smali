.class public Lcom/google/firebase/firestore/k;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Iterable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/firebase/firestore/k$a;
    }
.end annotation


# instance fields
.field public final a:Lcom/google/firebase/firestore/i;

.field public final b:Lg9/y1;

.field public final c:Lcom/google/firebase/firestore/FirebaseFirestore;

.field public d:Ljava/util/List;

.field public e:Ld9/b1;

.field public final f:Ld9/s1;


# direct methods
.method public constructor <init>(Lcom/google/firebase/firestore/i;Lg9/y1;Lcom/google/firebase/firestore/FirebaseFirestore;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    invoke-static {p1}, Ln9/x;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 5
    .line 6
    .line 7
    move-result-object p1

    .line 8
    check-cast p1, Lcom/google/firebase/firestore/i;

    .line 9
    .line 10
    iput-object p1, p0, Lcom/google/firebase/firestore/k;->a:Lcom/google/firebase/firestore/i;

    .line 11
    .line 12
    invoke-static {p2}, Ln9/x;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 13
    .line 14
    .line 15
    move-result-object p1

    .line 16
    check-cast p1, Lg9/y1;

    .line 17
    .line 18
    iput-object p1, p0, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 19
    .line 20
    invoke-static {p3}, Ln9/x;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 21
    .line 22
    .line 23
    move-result-object p1

    .line 24
    check-cast p1, Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 25
    .line 26
    iput-object p1, p0, Lcom/google/firebase/firestore/k;->c:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 27
    .line 28
    new-instance p1, Ld9/s1;

    .line 29
    .line 30
    invoke-virtual {p2}, Lg9/y1;->j()Z

    .line 31
    .line 32
    .line 33
    move-result p3

    .line 34
    invoke-virtual {p2}, Lg9/y1;->k()Z

    .line 35
    .line 36
    .line 37
    move-result p2

    .line 38
    invoke-direct {p1, p3, p2}, Ld9/s1;-><init>(ZZ)V

    .line 39
    .line 40
    .line 41
    iput-object p1, p0, Lcom/google/firebase/firestore/k;->f:Ld9/s1;

    .line 42
    .line 43
    return-void
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

.method public static synthetic a(Lcom/google/firebase/firestore/k;Lj9/h;)Lcom/google/firebase/firestore/j;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Lcom/google/firebase/firestore/k;->c(Lj9/h;)Lcom/google/firebase/firestore/j;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
    .line 6
    .line 7
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
.method public final c(Lj9/h;)Lcom/google/firebase/firestore/j;
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/google/firebase/firestore/k;->c:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 2
    .line 3
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 4
    .line 5
    invoke-virtual {v1}, Lg9/y1;->k()Z

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    iget-object v2, p0, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 10
    .line 11
    invoke-virtual {v2}, Lg9/y1;->f()Lg8/e;

    .line 12
    .line 13
    .line 14
    move-result-object v2

    .line 15
    invoke-interface {p1}, Lj9/h;->getKey()Lj9/k;

    .line 16
    .line 17
    .line 18
    move-result-object v3

    .line 19
    invoke-virtual {v2, v3}, Lg8/e;->contains(Ljava/lang/Object;)Z

    .line 20
    .line 21
    .line 22
    move-result v2

    .line 23
    invoke-static {v0, p1, v1, v2}, Lcom/google/firebase/firestore/j;->h(Lcom/google/firebase/firestore/FirebaseFirestore;Lj9/h;ZZ)Lcom/google/firebase/firestore/j;

    .line 24
    .line 25
    .line 26
    move-result-object p1

    .line 27
    return-object p1
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

.method public d()Ljava/util/List;
    .locals 1

    .line 1
    sget-object v0, Ld9/b1;->a:Ld9/b1;

    .line 2
    .line 3
    invoke-virtual {p0, v0}, Lcom/google/firebase/firestore/k;->e(Ld9/b1;)Ljava/util/List;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public e(Ld9/b1;)Ljava/util/List;
    .locals 2

    .line 1
    sget-object v0, Ld9/b1;->b:Ld9/b1;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_1

    .line 8
    .line 9
    iget-object v0, p0, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 10
    .line 11
    invoke-virtual {v0}, Lg9/y1;->b()Z

    .line 12
    .line 13
    .line 14
    move-result v0

    .line 15
    if-nez v0, :cond_0

    .line 16
    .line 17
    goto :goto_0

    .line 18
    :cond_0
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 19
    .line 20
    const-string v0, "To include metadata changes with your document changes, you must also pass MetadataChanges.INCLUDE to addSnapshotListener()."

    .line 21
    .line 22
    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 23
    .line 24
    .line 25
    throw p1

    .line 26
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/google/firebase/firestore/k;->d:Ljava/util/List;

    .line 27
    .line 28
    if-eqz v0, :cond_2

    .line 29
    .line 30
    iget-object v0, p0, Lcom/google/firebase/firestore/k;->e:Ld9/b1;

    .line 31
    .line 32
    if-eq v0, p1, :cond_3

    .line 33
    .line 34
    :cond_2
    iget-object v0, p0, Lcom/google/firebase/firestore/k;->c:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 35
    .line 36
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 37
    .line 38
    invoke-static {v0, p1, v1}, Ld9/g;->a(Lcom/google/firebase/firestore/FirebaseFirestore;Ld9/b1;Lg9/y1;)Ljava/util/List;

    .line 39
    .line 40
    .line 41
    move-result-object v0

    .line 42
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    .line 43
    .line 44
    .line 45
    move-result-object v0

    .line 46
    iput-object v0, p0, Lcom/google/firebase/firestore/k;->d:Ljava/util/List;

    .line 47
    .line 48
    iput-object p1, p0, Lcom/google/firebase/firestore/k;->e:Ld9/b1;

    .line 49
    .line 50
    :cond_3
    iget-object p1, p0, Lcom/google/firebase/firestore/k;->d:Ljava/util/List;

    .line 51
    .line 52
    return-object p1
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

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .line 1
    const/4 v0, 0x1

    .line 2
    if-ne p0, p1, :cond_0

    .line 3
    .line 4
    return v0

    .line 5
    :cond_0
    instance-of v1, p1, Lcom/google/firebase/firestore/k;

    .line 6
    .line 7
    const/4 v2, 0x0

    .line 8
    if-nez v1, :cond_1

    .line 9
    .line 10
    return v2

    .line 11
    :cond_1
    check-cast p1, Lcom/google/firebase/firestore/k;

    .line 12
    .line 13
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->c:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 14
    .line 15
    iget-object v3, p1, Lcom/google/firebase/firestore/k;->c:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 16
    .line 17
    invoke-virtual {v1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 18
    .line 19
    .line 20
    move-result v1

    .line 21
    if-eqz v1, :cond_2

    .line 22
    .line 23
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->a:Lcom/google/firebase/firestore/i;

    .line 24
    .line 25
    iget-object v3, p1, Lcom/google/firebase/firestore/k;->a:Lcom/google/firebase/firestore/i;

    .line 26
    .line 27
    invoke-virtual {v1, v3}, Lcom/google/firebase/firestore/i;->equals(Ljava/lang/Object;)Z

    .line 28
    .line 29
    .line 30
    move-result v1

    .line 31
    if-eqz v1, :cond_2

    .line 32
    .line 33
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 34
    .line 35
    iget-object v3, p1, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 36
    .line 37
    invoke-virtual {v1, v3}, Lg9/y1;->equals(Ljava/lang/Object;)Z

    .line 38
    .line 39
    .line 40
    move-result v1

    .line 41
    if-eqz v1, :cond_2

    .line 42
    .line 43
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->f:Ld9/s1;

    .line 44
    .line 45
    iget-object p1, p1, Lcom/google/firebase/firestore/k;->f:Ld9/s1;

    .line 46
    .line 47
    invoke-virtual {v1, p1}, Ld9/s1;->equals(Ljava/lang/Object;)Z

    .line 48
    .line 49
    .line 50
    move-result p1

    .line 51
    if-eqz p1, :cond_2

    .line 52
    .line 53
    return v0

    .line 54
    :cond_2
    return v2
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

.method public f()Ljava/util/List;
    .locals 3

    .line 1
    new-instance v0, Ljava/util/ArrayList;

    .line 2
    .line 3
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 4
    .line 5
    invoke-virtual {v1}, Lg9/y1;->e()Lj9/m;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    invoke-virtual {v1}, Lj9/m;->size()I

    .line 10
    .line 11
    .line 12
    move-result v1

    .line 13
    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 14
    .line 15
    .line 16
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 17
    .line 18
    invoke-virtual {v1}, Lg9/y1;->e()Lj9/m;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    invoke-virtual {v1}, Lj9/m;->iterator()Ljava/util/Iterator;

    .line 23
    .line 24
    .line 25
    move-result-object v1

    .line 26
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    .line 27
    .line 28
    .line 29
    move-result v2

    .line 30
    if-eqz v2, :cond_0

    .line 31
    .line 32
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 33
    .line 34
    .line 35
    move-result-object v2

    .line 36
    check-cast v2, Lj9/h;

    .line 37
    .line 38
    invoke-virtual {p0, v2}, Lcom/google/firebase/firestore/k;->c(Lj9/h;)Lcom/google/firebase/firestore/j;

    .line 39
    .line 40
    .line 41
    move-result-object v2

    .line 42
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 43
    .line 44
    .line 45
    goto :goto_0

    .line 46
    :cond_0
    return-object v0
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

.method public g()Ld9/s1;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/firebase/firestore/k;->f:Ld9/s1;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public hashCode()I
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/firebase/firestore/k;->c:Lcom/google/firebase/firestore/FirebaseFirestore;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    mul-int/lit8 v0, v0, 0x1f

    .line 8
    .line 9
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->a:Lcom/google/firebase/firestore/i;

    .line 10
    .line 11
    invoke-virtual {v1}, Lcom/google/firebase/firestore/i;->hashCode()I

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    add-int/2addr v0, v1

    .line 16
    mul-int/lit8 v0, v0, 0x1f

    .line 17
    .line 18
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 19
    .line 20
    invoke-virtual {v1}, Lg9/y1;->hashCode()I

    .line 21
    .line 22
    .line 23
    move-result v1

    .line 24
    add-int/2addr v0, v1

    .line 25
    mul-int/lit8 v0, v0, 0x1f

    .line 26
    .line 27
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->f:Ld9/s1;

    .line 28
    .line 29
    invoke-virtual {v1}, Ld9/s1;->hashCode()I

    .line 30
    .line 31
    .line 32
    move-result v1

    .line 33
    add-int/2addr v0, v1

    .line 34
    return v0
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

.method public iterator()Ljava/util/Iterator;
    .locals 2

    .line 1
    new-instance v0, Lcom/google/firebase/firestore/k$a;

    .line 2
    .line 3
    iget-object v1, p0, Lcom/google/firebase/firestore/k;->b:Lg9/y1;

    .line 4
    .line 5
    invoke-virtual {v1}, Lg9/y1;->e()Lj9/m;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    invoke-virtual {v1}, Lj9/m;->iterator()Ljava/util/Iterator;

    .line 10
    .line 11
    .line 12
    move-result-object v1

    .line 13
    invoke-direct {v0, p0, v1}, Lcom/google/firebase/firestore/k$a;-><init>(Lcom/google/firebase/firestore/k;Ljava/util/Iterator;)V

    .line 14
    .line 15
    .line 16
    return-object v0
.end method
