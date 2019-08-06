function getStudentCurrentArea(code) {
    $.ajax({
        type: 'get',
        url: '/location/getCurrentAreaList',
        data:{"code": code},
        cache: false,
        async:true,
        dataType: 'JSON',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            if (res.code === 200) {
                $('#stuArea').append("<option value=''>请选择地区</option>")
                $.each(res.areaList, function (index, item) {
                    let areaCode = res.areaList[index].code
                    let areaName = res.areaList[index].name
                    $('#stuArea').append("<option id='"+areaCode+"' value='"+areaCode+"'>"+areaName+"</option>")
                })
                $('#stuArea').val(code)
            } else {
                $.myNotify.danger(res.msg)
            }
        },
        error: function () {
            $.myNotify.danger("发生不可预知的错误")
        }
    });
}

function getStudentCurrentCity(code) {
    $.ajax({
        type: 'get',
        url: '/location/getCurrentCityList',
        data:{"code": code},
        cache: false,
        async:true,
        dataType: 'JSON',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            if (res.code === 200) {
                $('#stuCity').append("<option value=''>请选择城市</option>")
                $.each(res.cityList, function (index, item) {
                    let cityCode = res.cityList[index].code
                    let cityName = res.cityList[index].name
                    $('#stuCity').append("<option id='"+cityCode+"' value='"+cityName+"'>"+cityName+"</option>")
                })
                var cityName = $('#' + res.cityCode).val()
                var provinceName = $('#' + res.provinceCode).val()
                $('#stuCity').val(cityName)
                $('#stuProvince').val(provinceName)
            } else {
                $.myNotify.danger(res.msg)
            }
        },
        error: function () {
            $.myNotify.danger("发生不可预知的错误")
        }
    });
}

function getComCurrentArea(code) {
    $.ajax({
        type: 'get',
        url: '/location/getCurrentAreaList',
        data:{"code": code},
        cache: false,
        async:true,
        dataType: 'JSON',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            if (res.code === 200) {
                $('#comArea').append("<option value=''>请选择地区</option>")
                $.each(res.areaList, function (index, item) {
                    let areaCode = res.areaList[index].code
                    let areaName = res.areaList[index].name
                    $('#comArea').append("<option id='"+areaCode+"' value='"+areaCode+"'>"+areaName+"</option>")
                })
                $('#comArea').val(code)
            } else {
                $.myNotify.danger(res.msg)
            }
        },
        error: function () {
            $.myNotify.danger("发生不可预知的错误")
        }
    });
}

function getComCurrentCity(code) {
    $.ajax({
        type: 'get',
        url: '/location/getCurrentCityList',
        data:{"code": code},
        cache: false,
        async:true,
        dataType: 'JSON',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            if (res.code === 200) {
                $('#comArea').append("<option value=''>请选择城市</option>")
                $.each(res.cityList, function (index, item) {
                    let cityCode = res.cityList[index].code
                    let cityName = res.cityList[index].name
                    $('#comCity').append("<option id='"+cityCode+"' value='"+cityName+"'>"+cityName+"</option>")
                })
                var cityName = $('#' + res.cityCode).val()
                var provinceName = $('#' + res.provinceCode).val()
                $('#comCity').val(cityName)
                $('#comProvince').val(provinceName)
            } else {
                $.myNotify.danger(res.msg)
            }
        },
        error: function () {
            $.myNotify.danger("发生不可预知的错误")
        }
    });
}

function getIComCurrentArea(code) {
    $.ajax({
        type: 'get',
        url: '/location/getCurrentAreaList',
        data:{"code": code},
        cache: false,
        async:true,
        dataType: 'JSON',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            if (res.code === 200) {
                $('#icomArea').append("<option value=''>请选择地区</option>")
                $.each(res.areaList, function (index, item) {
                    let areaCode = res.areaList[index].code
                    let areaName = res.areaList[index].name
                    $('#icomArea').append("<option id='"+areaCode+"' value='"+areaCode+"'>"+areaName+"</option>")
                })
                $('#icomArea').val(code)
            } else {
                $.myNotify.danger(res.msg)
            }
        },
        error: function () {
            $.myNotify.danger("发生不可预知的错误")
        }
    });
}

function getIComCurrentCity(code) {
    $.ajax({
        type: 'get',
        url: '/location/getCurrentCityList',
        data:{"code": code},
        cache: false,
        async:true,
        dataType: 'JSON',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            if (res.code === 200) {
                $('#icomCity').append("<option value=''>请选择城市</option>")
                $.each(res.cityList, function (index, item) {
                    let cityCode = res.cityList[index].code
                    let cityName = res.cityList[index].name
                    $('#icomCity').append("<option id='"+cityCode+"' value='"+cityName+"'>"+cityName+"</option>")
                })
                var cityName = $('#' + res.cityCode).val()
                var provinceName = $('#' + res.provinceCode).val()
                $('#icomCity').val(cityName)
                $('#icomProvince').val(provinceName)
            } else {
                $.myNotify.danger(res.msg)
            }
        },
        error: function () {
            $.myNotify.danger("发生不可预知的错误")
        }
    });
}

