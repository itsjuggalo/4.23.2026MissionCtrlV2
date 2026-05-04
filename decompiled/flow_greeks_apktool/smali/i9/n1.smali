.class public Li9/n1;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public a:Lg8/e;

.field public b:Lg8/e;


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Lg8/e;

    .line 5
    .line 6
    sget-object v1, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    .line 7
    .line 8
    sget-object v2, Li9/e;->c:Ljava/util/Comparator;

    .line 9
    .line 10
    invoke-direct {v0, v1, v2}, Lg8/e;-><init>(Ljava/util/List;Ljava/util/Comparator;)V

    .line 11
    .line 12
    .line 13
    iput-object v0, p0, Li9/n1;->a:Lg8/e;

    .line 14
    .line 15
    new-instance v0, Lg8/e;

    .line 16
    .line 17
    sget-object v2, Li9/e;->d:Ljava/util/Comparator;

    .line 18
    .line 19
    invoke-direct {v0, v1, v2}, Lg8/e;-><init>(Ljava/util/List;Ljava/util/Comparator;)V

    .line 20
    .line 21
    .line 22
    iput-object v0, p0, Li9/n1;->b:Lg8/e;

    .line 23
    .line 24
    return-void
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
.end method


# virtual methods
.method public a(Lj9/k;I)V
    .locals 1

    .line 1
    new-instance v0, Li9/e;

    .line 2
    .line 3
    invoke-direct {v0, p1, p2}, Li9/e;-><init>(Lj9/k;I)V

    .line 4
    .line 5
    .line 6
    iget-object p1, p0, Li9/n1;->a:Lg8/e;

    .line 7
    .line 8
    invoke-virtual {p1, v0}, Lg8/e;->e(Ljava/lang/Object;)Lg8/e;

    .line 9
    .line 10
    .line 11
    move-result-object p1

    .line 12
    iput-object p1, p0, Li9/n1;->a:Lg8/e;

    .line 13
    .line 14
    iget-object p1, p0, Li9/n1;->b:Lg8/e;

    .line 15
    .line 16
    invoke-virtual {p1, v0}, Lg8/e;->e(Ljava/lang/Object;)Lg8/e;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    iput-object p1, p0, Li9/n1;->b:Lg8/e;

    .line 21
    .line 22
    return-void
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

.method public b(Lg8/e;I)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Lg8/e;->iterator()Ljava/util/Iterator;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    check-cast v0, Lj9/k;

    .line 16
    .line 17
    invoke-virtual {p0, v0, p2}, Li9/n1;->a(Lj9/k;I)V

    .line 18
    .line 19
    .line 20
    goto :goto_0

    .line 21
    :cond_0
    return-void
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

.method public c(Lj9/k;)Z
    .locals 3

    .line 1
    new-instance v0, Li9/e;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, p1, v1}, Li9/e;-><init>(Lj9/k;I)V

    .line 5
    .line 6
    .line 7
    iget-object v2, p0, Li9/n1;->a:Lg8/e;

    .line 8
    .line 9
    invoke-virtual {v2, v0}, Lg8/e;->f(Ljava/lang/Object;)Ljava/util/Iterator;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 14
    .line 15
    .line 16
    move-result v2

    .line 17
    if-nez v2, :cond_0

    .line 18
    .line 19
    return v1

    .line 20
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    check-cast v0, Li9/e;

    .line 25
    .line 26
    invoke-virtual {v0}, Li9/e;->d()Lj9/k;

    .line 27
    .line 28
    .line 29
    move-result-object v0

    .line 30
    invoke-virtual {v0, p1}, Lj9/k;->equals(Ljava/lang/Object;)Z

    .line 31
    .line 32
    .line 33
    move-result p1

    .line 34
    return p1
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

.method public d(I)Lg8/e;
    .locals 4

    .line 1
    invoke-static {}, Lj9/k;->c()Lj9/k;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    new-instance v1, Li9/e;

    .line 6
    .line 7
    invoke-direct {v1, v0, p1}, Li9/e;-><init>(Lj9/k;I)V

    .line 8
    .line 9
    .line 10
    iget-object v0, p0, Li9/n1;->b:Lg8/e;

    .line 11
    .line 12
    invoke-virtual {v0, v1}, Lg8/e;->f(Ljava/lang/Object;)Ljava/util/Iterator;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    invoke-static {}, Lj9/k;->h()Lg8/e;

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 21
    .line 22
    .line 23
    move-result v2

    .line 24
    if-eqz v2, :cond_0

    .line 25
    .line 26
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 27
    .line 28
    .line 29
    move-result-object v2

    .line 30
    check-cast v2, Li9/e;

    .line 31
    .line 32
    invoke-virtual {v2}, Li9/e;->c()I

    .line 33
    .line 34
    .line 35
    move-result v3

    .line 36
    if-ne v3, p1, :cond_0

    .line 37
    .line 38
    invoke-virtual {v2}, Li9/e;->d()Lj9/k;

    .line 39
    .line 40
    .line 41
    move-result-object v2

    .line 42
    invoke-virtual {v1, v2}, Lg8/e;->e(Ljava/lang/Object;)Lg8/e;

    .line 43
    .line 44
    .line 45
    move-result-object v1

    .line 46
    goto :goto_0

    .line 47
    :cond_0
    return-object v1
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

.method public final e(Li9/e;)V
    .locals 1

    .line 1
    iget-object v0, p0, Li9/n1;->a:Lg8/e;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lg8/e;->g(Ljava/lang/Object;)Lg8/e;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iput-object v0, p0, Li9/n1;->a:Lg8/e;

    .line 8
    .line 9
    iget-object v0, p0, Li9/n1;->b:Lg8/e;

    .line 10
    .line 11
    invoke-virtual {v0, p1}, Lg8/e;->g(Ljava/lang/Object;)Lg8/e;

    .line 12
    .line 13
    .line 14
    move-result-object p1

    .line 15
    iput-object p1, p0, Li9/n1;->b:Lg8/e;

    .line 16
    .line 17
    return-void
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public f(Lj9/k;I)V
    .locals 1

    .line 1
    new-instance v0, Li9/e;

    .line 2
    .line 3
    invoke-direct {v0, p1, p2}, Li9/e;-><init>(Lj9/k;I)V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p0, v0}, Li9/n1;->e(Li9/e;)V

    .line 7
    .line 8
    .line 9
    return-void
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

.method public g(Lg8/e;I)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Lg8/e;->iterator()Ljava/util/Iterator;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    check-cast v0, Lj9/k;

    .line 16
    .line 17
    invoke-virtual {p0, v0, p2}, Li9/n1;->f(Lj9/k;I)V

    .line 18
    .line 19
    .line 20
    goto :goto_0

    .line 21
    :cond_0
    return-void
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

.method public h(I)Lg8/e;
    .locals 4

    .line 1
    invoke-static {}, Lj9/k;->c()Lj9/k;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    new-instance v1, Li9/e;

    .line 6
    .line 7
    invoke-direct {v1, v0, p1}, Li9/e;-><init>(Lj9/k;I)V

    .line 8
    .line 9
    .line 10
    iget-object v0, p0, Li9/n1;->b:Lg8/e;

    .line 11
    .line 12
    invoke-virtual {v0, v1}, Lg8/e;->f(Ljava/lang/Object;)Ljava/util/Iterator;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    invoke-static {}, Lj9/k;->h()Lg8/e;

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 21
    .line 22
    .line 23
    move-result v2

    .line 24
    if-eqz v2, :cond_0

    .line 25
    .line 26
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 27
    .line 28
    .line 29
    move-result-object v2

    .line 30
    check-cast v2, Li9/e;

    .line 31
    .line 32
    invoke-virtual {v2}, Li9/e;->c()I

    .line 33
    .line 34
    .line 35
    move-result v3

    .line 36
    if-ne v3, p1, :cond_0

    .line 37
    .line 38
    invoke-virtual {v2}, Li9/e;->d()Lj9/k;

    .line 39
    .line 40
    .line 41
    move-result-object v3

    .line 42
    invoke-virtual {v1, v3}, Lg8/e;->e(Ljava/lang/Object;)Lg8/e;

    .line 43
    .line 44
    .line 45
    move-result-object v1

    .line 46
    invoke-virtual {p0, v2}, Li9/n1;->e(Li9/e;)V

    .line 47
    .line 48
    .line 49
    goto :goto_0

    .line 50
    :cond_0
    return-object v1
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
