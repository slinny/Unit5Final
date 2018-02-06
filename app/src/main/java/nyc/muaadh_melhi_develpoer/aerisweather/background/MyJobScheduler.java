package nyc.muaadh_melhi_develpoer.aerisweather.background;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import nyc.muaadh_melhi_develpoer.aerisweather.jobs.RetrofitJob;

/**
 * Created by c4q on 2/4/18.
 */

public class MyJobScheduler {
    private final static String TAG = MyJobScheduler.class.getSimpleName();
    public final static int RETROFIT_JOB_ID = 0;

    public static void start(Context context) {

        //1-The scheduler is given to you by the system using getSystemService.
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);//?
        buildRetrofitJob(context, jobScheduler);
    }

    private static void buildRetrofitJob(Context applicationContext, JobScheduler jobScheduler) {
        //TODO: schedule a retrofitJOB to the job scheduler.
        //2-Next, you need a JobInfo.Builder object which is where you denote a job id and the class which contains
        // your job as well as any conditions you want to apply.
        JobInfo.Builder retrofitJob = new JobInfo
                .Builder(RETROFIT_JOB_ID, new ComponentName(applicationContext, RetrofitJob.class)) //id and my Job
                // .setPeriodic(TimeUnit.DAYS.toMillis(1 / 2))
                .setOverrideDeadline(100)
                .setPersisted(true); //when it reboot ?
        if (jobScheduler != null) {
            jobScheduler.schedule(retrofitJob.build());
        }


    }
}
