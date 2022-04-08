package com.example.barberappsecproject.model.remote.data

data class ServiceCategory(var name:String, var img:String, val id:String)

/*****
{
    "status": 0,
    "services": {
    "Haircuts": [
    {
        "serviceId": "1",
        "serviceName": "Blowout",
        "duration": "15",
        "cost": "15",
        "servicePic": "uploads/images/Services/1.jpg"
    },
    {
        "serviceId": "2",
        "serviceName": "Edge Up",
        "duration": "16",
        "cost": "20",
        "servicePic": "uploads/images/Services/2.jpg"
    },
    {
        "serviceId": "3",
        "serviceName": "Even Steven Cut",
        "duration": "12",
        "cost": "15",
        "servicePic": "uploads/images/Services/3.jpg"
    },
    {
        "serviceId": "4",
        "serviceName": "Faded Fahawk",
        "duration": "15",
        "cost": "30",
        "servicePic": "uploads/images/Services/4.jpg"
    },
    {
        "serviceId": "5",
        "serviceName": "Kidz Haircut",
        "duration": "12",
        "cost": "30",
        "servicePic": "uploads/images/Services/5.jpg"
    },
    {
        "serviceId": "6",
        "serviceName": "Mobile Services",
        "duration": "15",
        "cost": "30",
        "servicePic": "uploads/images/Services/6.jpg"
    },
    {
        "serviceId": "7",
        "serviceName": "Side Part Hair Cut",
        "duration": "15",
        "cost": "30",
        "servicePic": "uploads/images/Services/7.jpg"
    },
    {
        "serviceId": "64",
        "serviceName": "Kgf Style",
        "duration": "20",
        "cost": "150",
        "servicePic": "/uploads/images/Services/kgf_art.jpg"
    }
    ],
    "Shaves": [
    {
        "serviceId": "8",
        "serviceName": "Rozor Shave",
        "duration": "22",
        "cost": "45",
        "servicePic": "uploads/images/Services/8.jpg"
    },
    {
        "serviceId": "9",
        "serviceName": "Trimmer",
        "duration": "15",
        "cost": "30",
        "servicePic": "uploads/images/Services/9.jpg"
    },
    {
        "serviceId": "10",
        "serviceName": "medicure and pedicure",
        "duration": "5",
        "cost": "0",
        "servicePic": "/uploads/images/Services/121.jpg"
    }
    ],
    "facial": [
    {
        "serviceId": "16",
        "serviceName": "facial 01",
        "duration": "30",
        "cost": "100",
        "servicePic": "/uploads/images/Services/YEJmQmJQdg.jpg"
    },
    {
        "serviceId": "17",
        "serviceName": "style 09",
        "duration": "70",
        "cost": "50",
        "servicePic": "/uploads/images/Services/YUBhQWZRcQ.jpg"
    }
    ],
    "Head Massage": [
    {
        "serviceId": "34",
        "serviceName": "Relaxation ",
        "duration": "45",
        "cost": "500",
        "servicePic": "/uploads/images/Services/images_(2)2.jpeg"
    }
    ],
    "Massages & Spa": [
    {
        "serviceId": "35",
        "serviceName": "Deep Body, Neck , Shoulder Massage",
        "duration": "60",
        "cost": "1000",
        "servicePic": "/uploads/images/Services/images.jpeg"
    },
    {
        "serviceId": "42",
        "serviceName": "Secret Facial Massage",
        "duration": "60",
        "cost": "500",
        "servicePic": "/uploads/images/Services/images_(2).jpeg"
    },
    {
        "serviceId": "43",
        "serviceName": "Lifting-Facial Massage",
        "duration": "45",
        "cost": "400",
        "servicePic": "/uploads/images/Services/images_(3).jpeg"
    }
    ],
    "Official looks": [
    {
        "serviceId": "44",
        "serviceName": "Official Look 1",
        "duration": "45",
        "cost": "80",
        "servicePic": "/uploads/images/Services/38c97c75d9278f5f3c494c86a0b49f1c.jpg"
    },
    {
        "serviceId": "45",
        "serviceName": "Min Hair Style",
        "duration": "20",
        "cost": "80",
        "servicePic": "/uploads/images/Services/images_(5)1.jpeg"
    },
    {
        "serviceId": "46",
        "serviceName": "Cute Formal Look",
        "duration": "20",
        "cost": "80",
        "servicePic": "/uploads/images/Services/formal-hairstyles-for-men-chic1.jpg"
    }
    ],
    "Hair colors": [
    {
        "serviceId": "47",
        "serviceName": "Love The Mix Of Green+Blue",
        "duration": "30",
        "cost": "150",
        "servicePic": "/uploads/images/Services/f12fae4be4b0a2ef6074a9e313cf496f--dyed-hair-hair-colours.jpg"
    },
    {
        "serviceId": "48",
        "serviceName": "Straight side parted dark Brown",
        "duration": "40",
        "cost": "200",
        "servicePic": "/uploads/images/Services/9d08aa88b270aff6beb4e98f93047103.jpg"
    },
    {
        "serviceId": "49",
        "serviceName": "Burgundy Hair Male ",
        "duration": "45",
        "cost": "200",
        "servicePic": "/uploads/images/Services/images_(7).jpeg"
    }
    ],
    "Beard styles": [
    {
        "serviceId": "50",
        "serviceName": "Maharaj",
        "duration": "30",
        "cost": "250",
        "servicePic": "/uploads/images/Services/images_(9).jpeg"
    },
    {
        "serviceId": "51",
        "serviceName": "French With Outside Trim ",
        "duration": "30",
        "cost": "150",
        "servicePic": "/uploads/images/Services/Best-Pakistani-mens-hairstyles-for-summer-19.jpg"
    },
    {
        "serviceId": "52",
        "serviceName": "Virat Style",
        "duration": "30",
        "cost": "150",
        "servicePic": "/uploads/images/Services/images_(11).jpeg"
    },
    {
        "serviceId": "53",
        "serviceName": "Trimming Design",
        "duration": "40",
        "cost": "150",
        "servicePic": "/uploads/images/Services/images_(10).jpeg"
    }
    ],
    "Combo Offers": [
    {
        "serviceId": "54",
        "serviceName": "Diwali Offer",
        "duration": "120",
        "cost": "1000",
        "servicePic": "/uploads/images/Services/big-diwali-offer-banner-design-vector-15661109.jpg"
    },
    {
        "serviceId": "56",
        "serviceName": "Dussehra Offer",
        "duration": "120",
        "cost": "700",
        "servicePic": "/uploads/images/Services/dussehra-festival-sale-discount-offer-smiling-face-dussehra-festival-sale-discount-offer-smiling-face-mythological-123732404.jpg"
    }
    ]
}
}
***/