<template>
  <v-app>
    <v-app-bar app color="pink lighten-4" dark>
      <v-btn href="http://freelance108.com/" target="_blank" text>
        <span class="mr-2 font-weight-black">Freelance108</span>
      </v-btn>

      <v-spacer></v-spacer>

      <v-row justify="center">
        <v-btn href="http://freelance108.com/" target="_blank" text>
          <span class="mr-2 font-weight-medium">Home</span>
        </v-btn>

        <v-btn href="http://freelance108.com/" target="_blank" text>
          <span class="mr-2 font-weight-medium">ฟรีแลนซ์</span>
        </v-btn>

        <v-btn href="http://localhost:8080/" text>
          <span class="mr-2 font-weight-medium">ผู้ว่าจ้างงาน</span>
        </v-btn>

        <v-btn href="http://localhost:8080/" text>
          <span class="mr-2 font-weight-medium">Activity</span>
        </v-btn>
      </v-row>

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
    </v-app-bar>

    <v-content>
      <Customer />
    </v-content>
  </v-app>
</template>

<script>
import Customer from "./components/Customer";

export default {
  name: "App",

  components: {
    Customer
  },

  data: () => ({
    //
  })
};
</script>
