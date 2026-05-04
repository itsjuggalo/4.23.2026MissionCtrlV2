.class public final enum Lce/r;
.super Ljava/lang/Enum;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field public static final enum d:Lce/r;

.field public static final enum e:Lce/r;

.field public static final enum f:Lce/r;

.field public static final enum g:Lce/r;

.field public static final synthetic h:[Lce/r;

.field public static final synthetic i:Ljd/a;


# instance fields
.field public final a:Lef/b;

.field public final b:Lef/f;

.field public final c:Lef/b;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .line 1
    new-instance v0, Lce/r;

    .line 2
    .line 3
    sget-object v1, Lef/b;->d:Lef/b$a;

    .line 4
    .line 5
    const-string v2, "kotlin/UByte"

    .line 6
    .line 7
    const/4 v3, 0x0

    .line 8
    const/4 v4, 0x2

    .line 9
    const/4 v5, 0x0

    .line 10
    invoke-static {v1, v2, v3, v4, v5}, Lef/b$a;->b(Lef/b$a;Ljava/lang/String;ZILjava/lang/Object;)Lef/b;

    .line 11
    .line 12
    .line 13
    move-result-object v2

    .line 14
    const-string v6, "UBYTE"

    .line 15
    .line 16
    invoke-direct {v0, v6, v3, v2}, Lce/r;-><init>(Ljava/lang/String;ILef/b;)V

    .line 17
    .line 18
    .line 19
    sput-object v0, Lce/r;->d:Lce/r;

    .line 20
    .line 21
    new-instance v0, Lce/r;

    .line 22
    .line 23
    const-string v2, "kotlin/UShort"

    .line 24
    .line 25
    invoke-static {v1, v2, v3, v4, v5}, Lef/b$a;->b(Lef/b$a;Ljava/lang/String;ZILjava/lang/Object;)Lef/b;

    .line 26
    .line 27
    .line 28
    move-result-object v2

    .line 29
    const-string v6, "USHORT"

    .line 30
    .line 31
    const/4 v7, 0x1

    .line 32
    invoke-direct {v0, v6, v7, v2}, Lce/r;-><init>(Ljava/lang/String;ILef/b;)V

    .line 33
    .line 34
    .line 35
    sput-object v0, Lce/r;->e:Lce/r;

    .line 36
    .line 37
    new-instance v0, Lce/r;

    .line 38
    .line 39
    const-string v2, "kotlin/UInt"

    .line 40
    .line 41
    invoke-static {v1, v2, v3, v4, v5}, Lef/b$a;->b(Lef/b$a;Ljava/lang/String;ZILjava/lang/Object;)Lef/b;

    .line 42
    .line 43
    .line 44
    move-result-object v2

    .line 45
    const-string v6, "UINT"

    .line 46
    .line 47
    invoke-direct {v0, v6, v4, v2}, Lce/r;-><init>(Ljava/lang/String;ILef/b;)V

    .line 48
    .line 49
    .line 50
    sput-object v0, Lce/r;->f:Lce/r;

    .line 51
    .line 52
    new-instance v0, Lce/r;

    .line 53
    .line 54
    const-string v2, "kotlin/ULong"

    .line 55
    .line 56
    invoke-static {v1, v2, v3, v4, v5}, Lef/b$a;->b(Lef/b$a;Ljava/lang/String;ZILjava/lang/Object;)Lef/b;

    .line 57
    .line 58
    .line 59
    move-result-object v1

    .line 60
    const-string v2, "ULONG"

    .line 61
    .line 62
    const/4 v3, 0x3

    .line 63
    invoke-direct {v0, v2, v3, v1}, Lce/r;-><init>(Ljava/lang/String;ILef/b;)V

    .line 64
    .line 65
    .line 66
    sput-object v0, Lce/r;->g:Lce/r;

    .line 67
    .line 68
    invoke-static {}, Lce/r;->a()[Lce/r;

    .line 69
    .line 70
    .line 71
    move-result-object v0

    .line 72
    sput-object v0, Lce/r;->h:[Lce/r;

    .line 73
    .line 74
    invoke-static {v0}, Ljd/b;->a([Ljava/lang/Enum;)Ljd/a;

    .line 75
    .line 76
    .line 77
    move-result-object v0

    .line 78
    sput-object v0, Lce/r;->i:Ljd/a;

    .line 79
    .line 80
    return-void
    .line 81
    .line 82
.end method

.method public constructor <init>(Ljava/lang/String;ILef/b;)V
    .locals 1

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 2
    .line 3
    .line 4
    iput-object p3, p0, Lce/r;->a:Lef/b;

    .line 5
    .line 6
    invoke-virtual {p3}, Lef/b;->h()Lef/f;

    .line 7
    .line 8
    .line 9
    move-result-object p1

    .line 10
    iput-object p1, p0, Lce/r;->b:Lef/f;

    .line 11
    .line 12
    new-instance p2, Lef/b;

    .line 13
    .line 14
    invoke-virtual {p3}, Lef/b;->f()Lef/c;

    .line 15
    .line 16
    .line 17
    move-result-object p3

    .line 18
    new-instance v0, Ljava/lang/StringBuilder;

    .line 19
    .line 20
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 21
    .line 22
    .line 23
    invoke-virtual {p1}, Lef/f;->b()Ljava/lang/String;

    .line 24
    .line 25
    .line 26
    move-result-object p1

    .line 27
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 28
    .line 29
    .line 30
    const-string p1, "Array"

    .line 31
    .line 32
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 33
    .line 34
    .line 35
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 36
    .line 37
    .line 38
    move-result-object p1

    .line 39
    invoke-static {p1}, Lef/f;->k(Ljava/lang/String;)Lef/f;

    .line 40
    .line 41
    .line 42
    move-result-object p1

    .line 43
    const-string v0, "identifier(...)"

    .line 44
    .line 45
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 46
    .line 47
    .line 48
    invoke-direct {p2, p3, p1}, Lef/b;-><init>(Lef/c;Lef/f;)V

    .line 49
    .line 50
    .line 51
    iput-object p2, p0, Lce/r;->c:Lef/b;

    .line 52
    .line 53
    return-void
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
.end method

.method public static final synthetic a()[Lce/r;
    .locals 4

    .line 1
    sget-object v0, Lce/r;->d:Lce/r;

    .line 2
    .line 3
    sget-object v1, Lce/r;->e:Lce/r;

    .line 4
    .line 5
    sget-object v2, Lce/r;->f:Lce/r;

    .line 6
    .line 7
    sget-object v3, Lce/r;->g:Lce/r;

    .line 8
    .line 9
    filled-new-array {v0, v1, v2, v3}, [Lce/r;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    return-object v0
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public static valueOf(Ljava/lang/String;)Lce/r;
    .locals 1

    .line 1
    const-class v0, Lce/r;

    .line 2
    .line 3
    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Lce/r;

    .line 8
    .line 9
    return-object p0
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
.end method

.method public static values()[Lce/r;
    .locals 1

    .line 1
    sget-object v0, Lce/r;->h:[Lce/r;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, [Lce/r;

    .line 8
    .line 9
    return-object v0
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
.end method


# virtual methods
.method public final b()Lef/b;
    .locals 1

    .line 1
    iget-object v0, p0, Lce/r;->c:Lef/b;

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
    .line 17
    .line 18
    .line 19
.end method

.method public final c()Lef/b;
    .locals 1

    .line 1
    iget-object v0, p0, Lce/r;->a:Lef/b;

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
    .line 17
    .line 18
    .line 19
.end method

.method public final h()Lef/f;
    .locals 1

    .line 1
    iget-object v0, p0, Lce/r;->b:Lef/f;

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
    .line 17
    .line 18
    .line 19
.end method
