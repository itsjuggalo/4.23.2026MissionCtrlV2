.class public final Lwb/d;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field public static final d:Lhh/g;

.field public static final e:Lhh/g;

.field public static final f:Lhh/g;

.field public static final g:Lhh/g;

.field public static final h:Lhh/g;

.field public static final i:Lhh/g;

.field public static final j:Lhh/g;


# instance fields
.field public final a:Lhh/g;

.field public final b:Lhh/g;

.field public final c:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    const-string v0, ":status"

    .line 2
    .line 3
    invoke-static {v0}, Lhh/g;->c(Ljava/lang/String;)Lhh/g;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    sput-object v0, Lwb/d;->d:Lhh/g;

    .line 8
    .line 9
    const-string v0, ":method"

    .line 10
    .line 11
    invoke-static {v0}, Lhh/g;->c(Ljava/lang/String;)Lhh/g;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    sput-object v0, Lwb/d;->e:Lhh/g;

    .line 16
    .line 17
    const-string v0, ":path"

    .line 18
    .line 19
    invoke-static {v0}, Lhh/g;->c(Ljava/lang/String;)Lhh/g;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    sput-object v0, Lwb/d;->f:Lhh/g;

    .line 24
    .line 25
    const-string v0, ":scheme"

    .line 26
    .line 27
    invoke-static {v0}, Lhh/g;->c(Ljava/lang/String;)Lhh/g;

    .line 28
    .line 29
    .line 30
    move-result-object v0

    .line 31
    sput-object v0, Lwb/d;->g:Lhh/g;

    .line 32
    .line 33
    const-string v0, ":authority"

    .line 34
    .line 35
    invoke-static {v0}, Lhh/g;->c(Ljava/lang/String;)Lhh/g;

    .line 36
    .line 37
    .line 38
    move-result-object v0

    .line 39
    sput-object v0, Lwb/d;->h:Lhh/g;

    .line 40
    .line 41
    const-string v0, ":host"

    .line 42
    .line 43
    invoke-static {v0}, Lhh/g;->c(Ljava/lang/String;)Lhh/g;

    .line 44
    .line 45
    .line 46
    move-result-object v0

    .line 47
    sput-object v0, Lwb/d;->i:Lhh/g;

    .line 48
    .line 49
    const-string v0, ":version"

    .line 50
    .line 51
    invoke-static {v0}, Lhh/g;->c(Ljava/lang/String;)Lhh/g;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    sput-object v0, Lwb/d;->j:Lhh/g;

    .line 56
    .line 57
    return-void
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
.end method

.method public constructor <init>(Lhh/g;Lhh/g;)V
    .locals 0

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    iput-object p1, p0, Lwb/d;->a:Lhh/g;

    .line 5
    iput-object p2, p0, Lwb/d;->b:Lhh/g;

    .line 6
    invoke-virtual {p1}, Lhh/g;->B()I

    move-result p1

    add-int/lit8 p1, p1, 0x20

    invoke-virtual {p2}, Lhh/g;->B()I

    move-result p2

    add-int/2addr p1, p2

    iput p1, p0, Lwb/d;->c:I

    return-void
.end method

.method public constructor <init>(Lhh/g;Ljava/lang/String;)V
    .locals 0

    .line 2
    invoke-static {p2}, Lhh/g;->c(Ljava/lang/String;)Lhh/g;

    move-result-object p2

    invoke-direct {p0, p1, p2}, Lwb/d;-><init>(Lhh/g;Lhh/g;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-static {p1}, Lhh/g;->c(Ljava/lang/String;)Lhh/g;

    move-result-object p1

    invoke-static {p2}, Lhh/g;->c(Ljava/lang/String;)Lhh/g;

    move-result-object p2

    invoke-direct {p0, p1, p2}, Lwb/d;-><init>(Lhh/g;Lhh/g;)V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3

    .line 1
    instance-of v0, p1, Lwb/d;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-eqz v0, :cond_0

    .line 5
    .line 6
    check-cast p1, Lwb/d;

    .line 7
    .line 8
    iget-object v0, p0, Lwb/d;->a:Lhh/g;

    .line 9
    .line 10
    iget-object v2, p1, Lwb/d;->a:Lhh/g;

    .line 11
    .line 12
    invoke-virtual {v0, v2}, Lhh/g;->equals(Ljava/lang/Object;)Z

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    if-eqz v0, :cond_0

    .line 17
    .line 18
    iget-object v0, p0, Lwb/d;->b:Lhh/g;

    .line 19
    .line 20
    iget-object p1, p1, Lwb/d;->b:Lhh/g;

    .line 21
    .line 22
    invoke-virtual {v0, p1}, Lhh/g;->equals(Ljava/lang/Object;)Z

    .line 23
    .line 24
    .line 25
    move-result p1

    .line 26
    if-eqz p1, :cond_0

    .line 27
    .line 28
    const/4 p1, 0x1

    .line 29
    return p1

    .line 30
    :cond_0
    return v1
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
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
.end method

.method public hashCode()I
    .locals 2

    .line 1
    iget-object v0, p0, Lwb/d;->a:Lhh/g;

    .line 2
    .line 3
    invoke-virtual {v0}, Lhh/g;->hashCode()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const/16 v1, 0x20f

    .line 8
    .line 9
    add-int/2addr v1, v0

    .line 10
    mul-int/lit8 v1, v1, 0x1f

    .line 11
    .line 12
    iget-object v0, p0, Lwb/d;->b:Lhh/g;

    .line 13
    .line 14
    invoke-virtual {v0}, Lhh/g;->hashCode()I

    .line 15
    .line 16
    .line 17
    move-result v0

    .line 18
    add-int/2addr v1, v0

    .line 19
    return v1
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 1
    iget-object v0, p0, Lwb/d;->a:Lhh/g;

    .line 2
    .line 3
    invoke-virtual {v0}, Lhh/g;->K()Ljava/lang/String;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v1, p0, Lwb/d;->b:Lhh/g;

    .line 8
    .line 9
    invoke-virtual {v1}, Lhh/g;->K()Ljava/lang/String;

    .line 10
    .line 11
    .line 12
    move-result-object v1

    .line 13
    filled-new-array {v0, v1}, [Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    const-string v1, "%s: %s"

    .line 18
    .line 19
    invoke-static {v1, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    return-object v0
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
.end method
