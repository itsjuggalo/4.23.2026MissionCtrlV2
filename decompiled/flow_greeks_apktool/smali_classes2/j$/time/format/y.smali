.class public final enum Lj$/time/format/y;
.super Ljava/lang/Enum;
.source "SourceFile"


# static fields
.field public static final enum ALWAYS:Lj$/time/format/y;

.field public static final enum EXCEEDS_PAD:Lj$/time/format/y;

.field public static final enum NEVER:Lj$/time/format/y;

.field public static final enum NORMAL:Lj$/time/format/y;

.field public static final enum NOT_NEGATIVE:Lj$/time/format/y;

.field public static final synthetic a:[Lj$/time/format/y;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .line 84
    new-instance v0, Lj$/time/format/y;

    const-string v1, "NORMAL"

    const/4 v2, 0x0

    .line 76
    invoke-direct {v0, v1, v2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 84
    sput-object v0, Lj$/time/format/y;->NORMAL:Lj$/time/format/y;

    .line 92
    new-instance v1, Lj$/time/format/y;

    const-string v2, "ALWAYS"

    const/4 v3, 0x1

    .line 76
    invoke-direct {v1, v2, v3}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 92
    sput-object v1, Lj$/time/format/y;->ALWAYS:Lj$/time/format/y;

    .line 99
    new-instance v2, Lj$/time/format/y;

    const-string v3, "NEVER"

    const/4 v4, 0x2

    .line 76
    invoke-direct {v2, v3, v4}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 99
    sput-object v2, Lj$/time/format/y;->NEVER:Lj$/time/format/y;

    .line 106
    new-instance v3, Lj$/time/format/y;

    const-string v4, "NOT_NEGATIVE"

    const/4 v5, 0x3

    .line 76
    invoke-direct {v3, v4, v5}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 106
    sput-object v3, Lj$/time/format/y;->NOT_NEGATIVE:Lj$/time/format/y;

    .line 115
    new-instance v4, Lj$/time/format/y;

    const-string v5, "EXCEEDS_PAD"

    const/4 v6, 0x4

    .line 76
    invoke-direct {v4, v5, v6}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 115
    sput-object v4, Lj$/time/format/y;->EXCEEDS_PAD:Lj$/time/format/y;

    .line 76
    filled-new-array {v0, v1, v2, v3, v4}, [Lj$/time/format/y;

    move-result-object v0

    sput-object v0, Lj$/time/format/y;->a:[Lj$/time/format/y;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lj$/time/format/y;
    .locals 1

    .line 76
    const-class v0, Lj$/time/format/y;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lj$/time/format/y;

    return-object p0
.end method

.method public static values()[Lj$/time/format/y;
    .locals 1

    .line 76
    sget-object v0, Lj$/time/format/y;->a:[Lj$/time/format/y;

    invoke-virtual {v0}, [Lj$/time/format/y;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lj$/time/format/y;

    return-object v0
.end method
