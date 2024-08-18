MISSION_START
SCRIPT_NAME PRAC2

// Initializing vars
VAR_INT fouriron_comet fouriron_marker ahod_car ahod_dude ahod_marker the_party_taxi_ip_cab the_party_taxi_ip_marker the_party_taxi_ip_mercedes

allow_movement_after_cleanup = 0
selecting = 1

// Resetting vars that get altered through various practice items
flag_lawyer_mission2_passed = 0     // Disable phone
flag_mob_52 = 0                     // Leo call not taken
flag_protect_mission1_passed = 0    // Bar Brawl not passed
flag_assin_mission3_passed = 0      // Autocide not passed
flag_mob_97 = 0                     // Autocide call not taken
flag_mob_96 = 0                     // COATCI call not taken

GOSUB practice_begin2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOTO fail_mission2
ENDIF

GOSUB mission_cleanup2

TERMINATE_THIS_SCRIPT
MISSION_END

teleport_back2:
    SET_PLAYER_COORDINATES player1 -1155.529053 -1275.438477 14.813583
    SET_PLAYER_HEADING player1 180.0
    RETURN

fail_mission2:
allow_movement_after_cleanup = 1
PRINT_BIG M_FAIL 5000 1 // MISSION FAILED!
GOSUB mission_cleanup2
/*IF NOT HAS_DEATHARREST_BEEN_EXECUTED
    SET_PLAYER_COORDINATES player1 -1162.540771 -1303.468140 14.837565
    SET_PLAYER_HEADING player1 180.0
ENDIF*/
TERMINATE_THIS_SCRIPT
RETURN


practice_begin2:
flag_player_on_mission = 1
OVERRIDE_NEXT_RESTART -1155.529053 -1275.438477 14.813583 180.0
SET_AREA_VISIBLE VIS_MAIN_MAP // 04BB: select_interiour 0
SET_PLAYER_CONTROL player1 OFF

// Loading models
REQUEST_MODEL COMET
REQUEST_MODEL WASHING
REQUEST_MODEL KAUFMAN

REQUEST_MODEL HMOST
REQUEST_MODEL SPECIAL03

REQUEST_MODEL M4

LOAD_ALL_MODELS_NOW

// Giving player movement and providing weapons and money
    SET_PLAYER_CONTROL player1 ON

// Four Iron snipe
    CREATE_CAR COMET -1144.984619 -1291.015991 14.898906 fouriron_comet
    CHANGE_CAR_COLOUR fouriron_comet 19 1 // Bright pink
    SET_CAR_HEADING fouriron_comet 90.0
    SET_CAR_HEALTH fouriron_comet 10000
    ADD_SPHERE -1148.422974 -1290.974487 14.881677 2.0 fouriron_marker

// AHoD death strat
    CREATE_CAR WASHING -1143.283325 -1287.255493 -100.0 ahod_car
	CHANGE_CAR_COLOUR ahod_car 0 0
    SET_CAR_HEADING ahod_car 90.0
    SET_CAR_HEALTH ahod_car 10000
    FREEZE_CAR_POSITION ahod_car TRUE
    CREATE_CHAR_INSIDE_CAR ahod_car PEDTYPE_GANG_STREET HMOST ahod_dude
    ADD_SPHERE -1146.976807 -1287.038574 14.880610 2.0 ahod_marker

// The Party Taxi IP
    CREATE_CAR KAUFMAN -1142.901489 -1283.129639 -100.0 the_party_taxi_ip_cab
    SET_CAR_HEADING the_party_taxi_ip_cab 90.0
    SET_CAR_HEALTH the_party_taxi_ip_cab 10000
    FREEZE_CAR_POSITION the_party_taxi_ip_cab TRUE
    CREATE_CHAR_INSIDE_CAR the_party_taxi_ip_cab PEDTYPE_CIVFEMALE SPECIAL03 the_party_taxi_ip_mercedes
    ADD_SPHERE -1146.712646 -1283.178223 14.873811 2.0 the_party_taxi_ip_marker

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////// Wait loop for player's decision for practice, and the actual triggers for the spheres/markers /////////////
WHILE LOCATE_PLAYER_ANY_MEANS_2D player1 -1147.4 -1271.25 27.0 21.75 FALSE
    WAIT 0

// Four Iron snipe
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1148.422974 -1290.974487 14.881677 1.5 1.5 1.5 FALSE
        GOTO mission_cleanup2
    ENDIF

// AHoD death strat
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1146.976807 -1287.038574 14.880610 1.5 1.5 1.5 FALSE
        GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_M4 1
        GOTO mission_cleanup2
    ENDIF
// The Party Taxi IP
    IF LOCATE_PLAYER_ON_FOOT_3D player1 -1146.712646 -1283.178223 14.873811 1.5 1.5 1.5 FALSE
        GOTO mission_cleanup2
    ENDIF

ENDWHILE

// Fail if exit the area
selecting = 0
allow_movement_after_cleanup = 1

mission_cleanup2:
    REMOVE_SPHERE fouriron_marker
    REMOVE_SPHERE ahod_marker
    REMOVE_SPHERE the_party_taxi_ip_marker

    MARK_MODEL_AS_NO_LONGER_NEEDED COMET
    MARK_MODEL_AS_NO_LONGER_NEEDED WASHING
    MARK_MODEL_AS_NO_LONGER_NEEDED HMOST
    MARK_MODEL_AS_NO_LONGER_NEEDED SPECIAL03
    MARK_MODEL_AS_NO_LONGER_NEEDED M4

    DELETE_CAR fouriron_comet
    DELETE_CAR ahod_car
    DELETE_CAR the_party_taxi_ip_cab

    MISSION_HAS_FINISHED

    SET_PLAYER_CONTROL player1 OFF
    IF allow_movement_after_cleanup = 1
        SET_PLAYER_CONTROL player1 ON
    ENDIF

    flag_player_on_mission = 0
    selecting = 0
    RETURN