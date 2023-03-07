package com.example.myapplication

import android.os.Build
import org.json.JSONObject

class TeetimeRequestData {
    var fieldId: String? = null
    var widevine: String? = null
    var opId: String? = null
    var playDate: String? = null
    var sessionData: String? = null
    var argument1: String? = null
    var argument2: String? = null
    var argument3: String? = null
    var argument4: String? = null
    var argument5: String? = null
    var argument6: String? = null
    var argument7: String? = null
    var argument8: String? = null
    var argument9: String? = null
    var argument10: String? = null
    var argument11: String? = null
    var argument12: String? = null
    var argument13: String? = null
    var argument14: String? = null
    var argument15: String? = null
    var argument16: String? = null
    var argument17: String? = null
    var argument18: String? = null
    var argument19: String? = null
    var argument20: String? = null

    constructor() {}
    constructor(jsonObject: JSONObject) {
        try {
            fieldId = jsonObject["FieldId"] as String
        } catch (ex: Exception) {
        }
        try {
            widevine = jsonObject["Widevine"] as String
        } catch (ex: Exception) {
        }
        try {
            opId = jsonObject["OpId"] as String
        } catch (ex: Exception) {
        }
        try {
            playDate = jsonObject["PlayDate"] as String
        } catch (ex: Exception) {
        }
        try {
            sessionData = jsonObject["SessionData"] as String
        } catch (ex: Exception) {
        }
        try {
            argument1 = jsonObject["Argument1"] as String
        } catch (ex: Exception) {
        }
        try {
            argument2 = jsonObject["Argument2"] as String
        } catch (ex: Exception) {
        }
        try {
            argument3 = jsonObject["Argument3"] as String
        } catch (ex: Exception) {
        }
        try {
            argument4 = jsonObject["Argument4"] as String
        } catch (ex: Exception) {
        }
        try {
            argument5 = jsonObject["Argument5"] as String
        } catch (ex: Exception) {
        }
        try {
            argument6 = jsonObject["Argument6"] as String
        } catch (ex: Exception) {
        }
        try {
            argument7 = jsonObject["Argument7"] as String
        } catch (ex: Exception) {
        }
        try {
            argument8 = jsonObject["Argument8"] as String
        } catch (ex: Exception) {
        }
        try {
            argument9 = jsonObject["Argument9"] as String
        } catch (ex: Exception) {
        }
        try {
            argument10 = jsonObject["Argument10"] as String
        } catch (ex: Exception) {
        }
        try {
            argument11 = jsonObject["Argument11"] as String
        } catch (ex: Exception) {
        }
        try {
            argument12 = jsonObject["Argument12"] as String
        } catch (ex: Exception) {
        }
        try {
            argument13 = jsonObject["Argument13"] as String
        } catch (ex: Exception) {
        }
        try {
            argument14 = jsonObject["Argument14"] as String
        } catch (ex: Exception) {
        }
        try {
            argument15 = jsonObject["Argument15"] as String
        } catch (ex: Exception) {
        }
        try {
            argument16 = jsonObject["Argument16"] as String
        } catch (ex: Exception) {
        }
        try {
            argument17 = jsonObject["Argument17"] as String
        } catch (ex: Exception) {
        }
        try {
            argument18 = jsonObject["Argument18"] as String
        } catch (ex: Exception) {
        }
        try {
            argument19 = jsonObject["Argument19"] as String
        } catch (ex: Exception) {
        }
        try {
            argument20 = jsonObject["Argument20"] as String
        } catch (ex: Exception) {
        }
    }

    fun toJson(): JSONObject {
        val jsonObject = JSONObject()
        try {
            jsonObject.put("FieldId", fieldId)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Widevine", widevine)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("OpId", opId)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("PlayDate", playDate)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("SessionData", sessionData)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument1", argument1)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument2", argument2)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument3", argument3)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument4", argument4)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument5", argument5)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument6", argument6)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument7", argument7)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument8", argument8)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument9", argument9)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument10", argument10)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument11", argument11)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument12", argument12)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument13", argument13)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument14", argument14)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument15", argument15)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument16", argument16)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument17", argument17)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument18", argument18)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument19", argument19)
        } catch (ex: Exception) {
        }
        try {
            jsonObject.put("Argument20", argument20)
        } catch (ex: Exception) {
        }
        return jsonObject
    }

    companion object {
        fun setRequestData(
            arg01: String? = null,
            arg02: String? = null,
            arg03: String? = null,
            arg04: String? = null,
            arg05: String? = null,
            arg06: String? = null,
            arg07: String? = null,
            arg08: String? = null,
            arg09: String? = null,
            arg10: String? = null,
            arg11: String? = null,
            arg12: String? = null,
            arg13: String? = null,
            arg14: String? = null,
            arg15: String? = null,
            arg16: String? = null,
            arg17: String? = null,
            arg18: String? = null,
            arg19: String? = null,
            arg20: String? = null,
        ): TeetimeRequestData {
            val reqData = TeetimeRequestData()
            reqData.argument1 = arg01
            reqData.argument2 = arg02
            reqData.argument3 = arg03
            reqData.argument4 = arg04
            reqData.argument5 = arg05
            reqData.argument6 = arg06
            reqData.argument7 = arg07
            reqData.argument8 = arg08
            reqData.argument9 = arg09
            reqData.argument10 = arg10
            reqData.argument11 = arg11
            reqData.argument12 = arg12
            reqData.argument13 = arg13
            reqData.argument14 = arg14
            reqData.argument15 = arg15
            reqData.argument16 = arg16
            reqData.argument17 = arg17
            reqData.argument18 = arg18
            reqData.argument19 = arg19
            reqData.argument20 = arg20

            return reqData
        }
    }
}