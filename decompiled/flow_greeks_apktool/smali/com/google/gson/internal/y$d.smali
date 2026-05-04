.class public abstract Lcom/google/gson/internal/y$d;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/util/Iterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/gson/internal/y;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401
    name = "d"
.end annotation


# instance fields
.field public a:Lcom/google/gson/internal/y$e;

.field public b:Lcom/google/gson/internal/y$e;

.field public c:I

.field public final synthetic d:Lcom/google/gson/internal/y;


# direct methods
.method public constructor <init>(Lcom/google/gson/internal/y;)V
    .locals 1

    .line 1
    iput-object p1, p0, Lcom/google/gson/internal/y$d;->d:Lcom/google/gson/internal/y;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    iget-object v0, p1, Lcom/google/gson/internal/y;->f:Lcom/google/gson/internal/y$e;

    .line 7
    .line 8
    iget-object v0, v0, Lcom/google/gson/internal/y$e;->d:Lcom/google/gson/internal/y$e;

    .line 9
    .line 10
    iput-object v0, p0, Lcom/google/gson/internal/y$d;->a:Lcom/google/gson/internal/y$e;

    .line 11
    .line 12
    const/4 v0, 0x0

    .line 13
    iput-object v0, p0, Lcom/google/gson/internal/y$d;->b:Lcom/google/gson/internal/y$e;

    .line 14
    .line 15
    iget p1, p1, Lcom/google/gson/internal/y;->e:I

    .line 16
    .line 17
    iput p1, p0, Lcom/google/gson/internal/y$d;->c:I

    .line 18
    .line 19
    return-void
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method


# virtual methods
.method public final b()Lcom/google/gson/internal/y$e;
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/google/gson/internal/y$d;->a:Lcom/google/gson/internal/y$e;

    .line 2
    .line 3
    iget-object v1, p0, Lcom/google/gson/internal/y$d;->d:Lcom/google/gson/internal/y;

    .line 4
    .line 5
    iget-object v2, v1, Lcom/google/gson/internal/y;->f:Lcom/google/gson/internal/y$e;

    .line 6
    .line 7
    if-eq v0, v2, :cond_1

    .line 8
    .line 9
    iget v1, v1, Lcom/google/gson/internal/y;->e:I

    .line 10
    .line 11
    iget v2, p0, Lcom/google/gson/internal/y$d;->c:I

    .line 12
    .line 13
    if-ne v1, v2, :cond_0

    .line 14
    .line 15
    iget-object v1, v0, Lcom/google/gson/internal/y$e;->d:Lcom/google/gson/internal/y$e;

    .line 16
    .line 17
    iput-object v1, p0, Lcom/google/gson/internal/y$d;->a:Lcom/google/gson/internal/y$e;

    .line 18
    .line 19
    iput-object v0, p0, Lcom/google/gson/internal/y$d;->b:Lcom/google/gson/internal/y$e;

    .line 20
    .line 21
    return-object v0

    .line 22
    :cond_0
    new-instance v0, Ljava/util/ConcurrentModificationException;

    .line 23
    .line 24
    invoke-direct {v0}, Ljava/util/ConcurrentModificationException;-><init>()V

    .line 25
    .line 26
    .line 27
    throw v0

    .line 28
    :cond_1
    new-instance v0, Ljava/util/NoSuchElementException;

    .line 29
    .line 30
    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    .line 31
    .line 32
    .line 33
    throw v0
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

.method public final hasNext()Z
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/gson/internal/y$d;->a:Lcom/google/gson/internal/y$e;

    .line 2
    .line 3
    iget-object v1, p0, Lcom/google/gson/internal/y$d;->d:Lcom/google/gson/internal/y;

    .line 4
    .line 5
    iget-object v1, v1, Lcom/google/gson/internal/y;->f:Lcom/google/gson/internal/y$e;

    .line 6
    .line 7
    if-eq v0, v1, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

    .line 12
    return v0
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public final remove()V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/google/gson/internal/y$d;->b:Lcom/google/gson/internal/y$e;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v1, p0, Lcom/google/gson/internal/y$d;->d:Lcom/google/gson/internal/y;

    .line 6
    .line 7
    const/4 v2, 0x1

    .line 8
    invoke-virtual {v1, v0, v2}, Lcom/google/gson/internal/y;->g(Lcom/google/gson/internal/y$e;Z)V

    .line 9
    .line 10
    .line 11
    const/4 v0, 0x0

    .line 12
    iput-object v0, p0, Lcom/google/gson/internal/y$d;->b:Lcom/google/gson/internal/y$e;

    .line 13
    .line 14
    iget-object v0, p0, Lcom/google/gson/internal/y$d;->d:Lcom/google/gson/internal/y;

    .line 15
    .line 16
    iget v0, v0, Lcom/google/gson/internal/y;->e:I

    .line 17
    .line 18
    iput v0, p0, Lcom/google/gson/internal/y$d;->c:I

    .line 19
    .line 20
    return-void

    .line 21
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 22
    .line 23
    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    .line 24
    .line 25
    .line 26
    throw v0
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
