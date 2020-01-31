<template>
  <v-container style="background-color:#FCE4EC;" class="white--text" >
    <v-row justify="center">
    <v-col cols = "3">
      <v-flex>
        <h2 class="font-weight-medium display-1 pink lighten-4 text-center">ผู้ว่าจ้างงาน</h2>    
    </v-flex>
    </v-col>
    </v-row>
    

    <v-row justify="center">
      <v-col cols="2">
        <v-select
          label="ประเภทของงานที่ต้องการจ้าง"
          item-text
          item-value
          prepend-icon="work"
          required
        ></v-select>
      </v-col>

      <v-col cols="2">
        <v-select
          label="ประเภทของงานที่ต้องการจ้าง"
          item-text
          item-value
          prepend-icon="work"
          required
        ></v-select>
      </v-col>
    </v-row>

    <v-row justify="center">
      <v-col cols="4">
        <v-text-field label="ขนาดภาพ" prepend-icon="panorama" v-model="sizepicture"></v-text-field>

        <v-row justify="center">
          <v-menu offset-y>
            <template v-slot:activator="{ on }">
              <v-btn color="pink lighten-4" dark v-on="on">scale</v-btn>
            </template>
            <v-list>
              <v-list-item v-for="(item, index) in items" :key="index">
                <v-list-item-title>{{ item.title }}</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-menu>
        </v-row>
      </v-col>
    </v-row>

    <v-row justify="center">
      <v-col cols="4">
        <v-textarea
          color="pink lighten-1"
          block
          prepend-icon="comment"
          v-model="note"
          label="ประเภทของงานที่ต้องการว่าจ้าง"
        ></v-textarea>
      </v-col>
    </v-row>

    <v-row justify="center">
      <v-col cols="2">
        <v-menu
          v-model="menu1"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="120px"
        >
          <template v-slot:activator="{ on }">
            <v-text-field
              style="width:100%"
              prepend-icon="mdi mdi-calendar"
              v-model="expdate"
              label="วันเวลากำหนดส่งผลงาน"
              clearable
              readonly
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker v-model="expdate" @input="menu1 = false" color="pink lighten-4"></v-date-picker>
        </v-menu>
      </v-col>

      <v-col cols="2">
        <v-text-field label="งบประมาณของคุณ" prepend-icon="account_balance_wallet" v-model="sizepicture"></v-text-field>
      </v-col>
    </v-row>

    <v-row justify="center">
      <v-col cols="4">
        <v-text-field label="ไฟล์ที่จำเป็น & ต้องการใส่ในตัวงาน (เช่น โลโก้, ตัวสินค้า เป็นต้น)" prepend-icon="file_copy" v-model="sizepicture"></v-text-field>
      </v-col>
      </v-row>
<v-row justify="center">
      <v-col cols="4">
        <v-text-field label="Rfe. ตัวอย่างผลงานที่อยากได้ (มีหรือไม่มีก็ได้)" prepend-icon="attach_file" v-model="sizepicture"></v-text-field>
      </v-col>
    </v-row>

    <div class="text-center">
      <v-btn class="ma-5" tile color="pink lighten-4" dark v-on:click="save">เสร็จสิ้น</v-btn>
      <v-btn class="ma-5" tile color="pink lighten-4" dark v-on:click="cancel">ยกเลิก</v-btn>
    </div>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      myfrom: {},
      jobDescriptions: [],
      employees: [],
      selectJobDescriptions: "",
      employeesName: ""
    };
  },
  methods: {
    choseJobDescriptions() {
      axios
        .get(
          `http://localhost:9000/api/emp/findByJobId/${this.selectJobDescriptions}`
        )
        .then(reponse => {
          this.employeesName = reponse.data[0].name;
        });
    }
  },

  mounted() {
    axios.get(`http://localhost:9000/api/jobs`).then(response => {
      this.jobDescriptions = response.data;
    });
  }
};
</script>
